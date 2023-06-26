package com.example.springbasicprinciple.discount;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        final Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        final int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // given
        final Member member = new Member(1L, "memberVIP", Grade.BASIC);

        // when
        final int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isZero();
    }
}