package com.example.springbasicprinciple.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        final PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        final PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        assertThat(bean1).isNotSameAs(bean2);
    }

    @Scope("prototype")
    static class PrototypeBean {

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
