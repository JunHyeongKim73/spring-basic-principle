package com.example.springbasicprinciple.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    final MemberService memberService = new MemberServiceImpl();

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
