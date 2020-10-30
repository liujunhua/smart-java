package smart.java.reflect.service;

import java.lang.reflect.Method;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/10/2211:23
 */
public class ReflectService {
    public static void main(String[] args) throws Exception {
        Object service = Class.forName(ReflectService.class.getName()).newInstance();
        Method method = service.getClass().getMethod("sayHello", String.class);
        method.invoke(service, "liujunhua");
    }

    public void sayHello(String name) {
        System.out.println("hello," + name);
    }


}
