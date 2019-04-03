package framework;

import framework.ioc.BeanHelper;
import framework.ioc.IocHelper;
import framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author huangyong
 * @since 2.0
 */
public final class HelperLoader {

    public static void init() {
        // 定义需要加载的 Helper 类
        Class<?>[] classList = {
            BeanHelper.class,
            IocHelper.class,
        };
        // 按照顺序加载类
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
