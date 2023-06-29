package com.example.springbasicprinciple.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

class ComponentScanFilterAppConfigTest {

    @Test
    void filterScan() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        final BeanA beanA = ac.getBean(BeanA.class);

        assertThat(beanA).isNotNull();
        assertThatThrownBy(() -> ac.getBean(BeanB.class)).isInstanceOf(NoSuchBeanDefinitionException.class);

    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION,  classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class AppConfig {

    }
}
