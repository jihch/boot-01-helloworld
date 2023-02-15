package io.github.jihch.boot;

import ch.qos.logback.core.db.DBHelper;
import io.github.jihch.boot.bean.Pet;
import io.github.jihch.boot.bean.User;
import io.github.jihch.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


/**
 * 主程序类
 * @SpringBootApplication：这是一个 Spring Boot 应用
 */
@SpringBootApplication(scanBasePackages = "io.github.jihch")
public class MainApplication {

    public static void main(String[] args) {
        //1、返回 IOC 容器
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        //3、从容器中获取组件
//        Pet tom01 = context.getBean("tom", Pet.class);
//
//        Pet tom02 = context.getBean("tom", Pet.class);
//
//        System.out.println("组件：" + (tom01 == tom02));
//
//        //4、io.github.jihch.boot.config.MyConfig$$EnhancerBySpringCGLIB$$f0fca2ff@26c89563
//        MyConfig bean = context.getBean(MyConfig.class);
//
//        System.out.println(bean);
//
//        //如果 @Configuration(proxyBeanMethods = true) 代理对象调用方法。
//        //SpringBoot 总会检查这个组件是否在容器中有，保持组件单实例
//        User user = bean.user01();
//
//        User user1 = bean.user01();
//
//        System.out.println(user == user1);
//
//        User user01 = context.getBean("user01", User.class);
//
//        Pet tom = context.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物：" + (user01.getPet() == tom));
//
//        //5、获取组件、验证 @Import 导入组件的功能
//        String[] beanNamesForType = context.getBeanNamesForType(User.class);
//        System.out.println("======");
//        for (String s:beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper bean1 = context.getBean(DBHelper.class);
//        System.out.println(bean1);

        boolean tom = context.containsBean("tom");
        System.out.println("容器中 tom 组件：" + tom);

        boolean user01 = context.containsBean("user01");
        System.out.println("容器中 user01 组件：" + user01);

        boolean tom22 = context.containsBean("tom22");
        System.out.println("容器中 tom22 组件：" + tom22);

        boolean haha = context.containsBean("haha");
        boolean hehe = context.containsBean("hehe");
        System.out.println("haha:" + haha);
        System.out.println("hehe:" + hehe);

    }

}
