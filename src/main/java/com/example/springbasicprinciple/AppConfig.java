package com.example.springbasicprinciple;

import com.example.springbasicprinciple.discount.FixDiscountPolicy;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.member.MemberServiceImpl;
import com.example.springbasicprinciple.member.MemoryMemberRepository;
import com.example.springbasicprinciple.order.OrderService;
import com.example.springbasicprinciple.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}