package com.example.springbasicprinciple.scan;

import com.example.springbasicprinciple.AutoAppConfig;
import com.example.springbasicprinciple.discount.DiscountPolicy;
import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

class AllBeanTest {

    @Test
    void findAllBean() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        final DiscountService discountService = ac.getBean(DiscountService.class);
        final Member member = new Member(1L, "memberA", Grade.VIP);
        final int discount = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            final DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member, price);
        }
    }
}
