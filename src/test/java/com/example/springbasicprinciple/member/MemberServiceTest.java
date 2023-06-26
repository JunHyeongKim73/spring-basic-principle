package com.example.springbasicprinciple.member;

import com.example.springbasicprinciple.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        final AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void MemberServiceTest() {
        // given
        final Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        final Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
