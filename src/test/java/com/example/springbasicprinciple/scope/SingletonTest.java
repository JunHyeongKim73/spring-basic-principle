package com.example.springbasicprinciple.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    void singletonBeanFind() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        final SingletonBean bean1 = ac.getBean(SingletonBean.class);
        final SingletonBean bean2 = ac.getBean(SingletonBean.class);

        assertThat(bean1).isSameAs(bean2);
    }

    @Scope("singleton")
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("SingletonBean.close");
        }
    }
}
