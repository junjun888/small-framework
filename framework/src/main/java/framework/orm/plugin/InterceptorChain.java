package framework.orm.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description
 * @author: huangwenjun
 * @create: 2019-04-11 19:22
 **/
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors() {
        return Collections.unmodifiableList(interceptors);
    }

}
