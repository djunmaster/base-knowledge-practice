package cn.adam.util;

import cn.adam.api.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main(String[] args) {
        /*
            1.创建Spring的IOC容器，用来管理所有的Bean
            2.从IOC容器中获取Bean

            ClassPathXmlApplicationContext是ApplicationContext的一个实现类，它可以从类路径下加载XML配置文件。
            这意味着如果你的应用程序被打包成了JAR文件或者WAR文件，这个实现类仍然能够找到并加载配置文件，因为它是从类路径（即应用程序的classpath）中寻找配置文件的

            "applicationContext.xml"是你指定的配置文件的名字。
            在这个文件中，你可以定义各种Bean，比如BookDao，以及其他配置信息，如Bean的依赖关系、初始化方法等。
            通过这一行代码，实际上就是在创建一个Spring的IoC（Inversion of Control，控制反转）容器，并告诉容器去哪里找配置信息。Spring容器会根据配置文件中的定义来创建和管理Bean的生命周期
         */
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
            这行代码的作用是从Spring容器中获取一个名为bookDao的Bean，并将其强制转换为BookDao类型。
            这个字符串参数是Bean的名称，它对应于你在applicationContext.xml文件中定义的Bean的ID。Spring容器会根据这个ID找到相应的Bean定义，并返回一个Bean的实例。
         */
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        ctx.registerShutdownHook();
    }
}