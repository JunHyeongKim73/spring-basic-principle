package com.example.springbasicprinciple;

import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.order.Order;
import com.example.springbasicprinciple.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        final AppConfig appConfig = new AppConfig();
        final MemberService memberService = appConfig.memberService();
        final OrderService orderService = appConfig.orderService();

        final Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
    }
}
