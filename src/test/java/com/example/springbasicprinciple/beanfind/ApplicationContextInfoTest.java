package com.example.springbasicprinciple.beanfind;

import com.example.springbasicprinciple.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        // given
        final String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            final Object bean = ac.getBean(name);
            System.out.println("name = " + name + " object = " + bean);
        }

        // when

        // then
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAllApplicationBean() {
        // given
        final String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            final BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                final Object bean = ac.getBean(name);
                System.out.println("name = " + name + " object = " + bean);
            }
        }

        // when

        // then
    }
}
