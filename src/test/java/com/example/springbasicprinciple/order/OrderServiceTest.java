package com.example.springbasicprinciple.order;

import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    final MemberService memberService = new MemberServiceImpl();
    final OrderService orderService = new OrderServiceImpl();

    @Test
    void OrderServiceTest() {
        // given
        final Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
