package com.gghenshinn3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCTest {
    public void createIOC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");

/*        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring3.xml");
        applicationContext1.refresh();*/
    }
    @Test
    public void getBeanFromIOC(){
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring3.xml");
        applicationContext1.refresh();

        //方式1: 根据id获取
        //没有指定类型,返回为Object,需要类型转化!
        HappyComponent happyComponent =
                (HappyComponent) applicationContext1.getBean("happyComponent");

        //方式2: 根据类型获取
        //根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
        //配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        HappyComponent happyComponent1 = applicationContext1.getBean("happyComponent", HappyComponent.class);

        //方式3: 根据id和类型获取
        HappyComponent happyComponent2 = applicationContext1.getBean(HappyComponent.class);


        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent2 == happyComponent);
    }
}
