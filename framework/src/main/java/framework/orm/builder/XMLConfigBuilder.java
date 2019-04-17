package framework.orm.builder;

import framework.orm.mapping.MappedStatement;
import framework.orm.mapping.StaticSqlSource;
import framework.orm.session.Configuration;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 13:53
 **/
public class XMLConfigBuilder {

    private InputStream inputStream;

    public XMLConfigBuilder(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Configuration parse() {
        return loadXmlConfiguration(inputStream);
    }

    /**
     * 读取主配置文件
     *
     * @param inputStream
     * @return
     */
    public static Configuration loadXmlConfiguration(InputStream inputStream) {
        //使用dom4j和xpath解析主配置文件
        SAXReader reader = new SAXReader();
        Configuration config = new Configuration();
        try {
            //将主配置文件二进制流传入，得到document对象
            Document document = reader.read(inputStream);
            //获取property节点集合（用于生成连接对象的四大参数）
            List<Element> list = document.selectNodes("//property");
            for (Element element : list) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                if (name.equals("username")) config.setUsername(value);
                if (name.equals("driver")) config.setDriver(value);
                if (name.equals("password")) config.setPassword(value);
                if (name.equals("url")) config.setUrl(value);
            }
            //读取主配置文件下的所有mapper映射文件
            List<Element> listMapper = document.selectNodes("//mapper");
            for (Element element : listMapper) {
                //遍历每个mapper标签，获取resource属性（mapper映射文件的全限类名）
                String resource = element.attributeValue("resource");
                //使用dom4j和xpath解析mapper映射文件
                Map<String, MappedStatement> loadMapper = loadMapper(resource, config);
                config.setMappedStatements(loadMapper);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return config;
    }

    /**
     * 使用dom4j和xpath解析mapper映射文件
     *
     * @param resource
     * @return
     */
    private static Map<String, MappedStatement> loadMapper(String resource, Configuration config) {
        Map<String, MappedStatement> mappers = new HashMap<String, MappedStatement>();
        //利用类加载器将配置文件转换为二进制流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(inputStream);
            //获取根节点对象
            Element rootElement = document.getRootElement();
            //获取根节点的namespace属性值
            String namespace = rootElement.attributeValue("namespace");
            //获取根节点下所有select节点
            List<Element> selectNodes = rootElement.selectNodes("//select");
            //遍历，获取每个select节点的id、resultType以及sql语句等值
            for (Element selectNode : selectNodes) {
                String id = selectNode.attributeValue("id");
                String resultType = selectNode.attributeValue("resultType");
                String sql = selectNode.getTextTrim();
                //用一个mapper对象存储以上的值
                MappedStatement mapper = new MappedStatement();
                mapper.setConfiguration(config);
                mapper.setId(id);
                mapper.setResultType(Class.forName(resultType));
                mapper.setSqlSource(new StaticSqlSource(sql));
                //一个mapper映射文件可以有多个select（statment），不同映射文件里，select的id可以相同
                //所以将namespace+"."+id作为唯一标志，用于区分，并存入map集合里
                mappers.put(namespace + "." + id, mapper);
            }
            return mappers;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
