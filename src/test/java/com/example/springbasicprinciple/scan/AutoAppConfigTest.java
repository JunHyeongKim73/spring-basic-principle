package com.example.springbasicprinciple.scan;

import com.example.springbasicprinciple.AutoAppConfig;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {

    @Test
    void basicScan() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        final MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
