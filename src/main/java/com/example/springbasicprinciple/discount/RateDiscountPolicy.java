package com.example.springbasicprinciple.discount;

import com.example.springbasicprinciple.annotation.MainDiscountPolicy;
import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * DISCOUNT_PERCENT / 100;
        }

        return 0;
    }
}
