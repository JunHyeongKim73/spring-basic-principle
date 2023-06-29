package com.example.springbasicprinciple.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springbasicprinciple.AppConfig;
import com.example.springbasicprinciple.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        // given
        final AppConfig appConfig = new AppConfig();

        // when
        //1. 조회: 호출할 때 마다 객체를 생성
        final MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        final MemberService memberService2 = appConfig.memberService();

        // then
        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // given
        final SingletonService singletonService1 = SingletonService.getInstance();
        final SingletonService singletonService2 = SingletonService.getInstance();

        // then
        assertThat(singletonService1).isEqualTo(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        // given
        final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        //1. 조회: 호출할 때 마다 객체를 생성
        final MemberService memberService1 = ac.getBean(MemberService.class);

        //2. 조회: 호출할 때 마다 객체를 생성
        final MemberService memberService2 = ac.getBean(MemberService.class);

        // then
        // memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
