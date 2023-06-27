package com.example.springbasicprinciple;

import com.example.springbasicprinciple.discount.DiscountPolicy;
import com.example.springbasicprinciple.discount.RateDiscountPolicy;
import com.example.springbasicprinciple.member.MemberRepository;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.member.MemberServiceImpl;
import com.example.springbasicprinciple.member.MemoryMemberRepository;
import com.example.springbasicprinciple.order.OrderService;
import com.example.springbasicprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
