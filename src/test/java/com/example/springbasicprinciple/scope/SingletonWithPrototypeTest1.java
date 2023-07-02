package com.example.springbasicprinciple.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        final PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        bean1.addCount();;
        assertThat(bean1.getCount()).isEqualTo(1);

        final PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        bean2.addCount();;
        assertThat(bean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUserPrototype() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        final ClientBean bean1 = ac.getBean(ClientBean.class);
        final int count1 = bean1.logic();
        assertThat(count1).isEqualTo(1);

        final ClientBean bean2 = ac.getBean(ClientBean.class);
        final int count2 = bean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {
        private Provider<PrototypeBean> provider;

        @Autowired
        public ClientBean(Provider<PrototypeBean> provider) {
            this.provider = provider;
        }

        public int logic() {
            final PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
