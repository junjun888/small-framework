/**
 * Copyright (C), 2018, 杨智杰
 * FileName: Resources
 * Author:   猪猪
 * Date:     2018/12/27 22:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package framework.orm.builder;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String xmlPath) {
        //利用类加载器将配置文件转换为二进制流
        InputStream is = Resources.class.getClassLoader().getResourceAsStream(xmlPath);
        return is;
    }
}
