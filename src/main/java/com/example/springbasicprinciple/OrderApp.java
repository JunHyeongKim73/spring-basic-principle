package com.example.springbasicprinciple;

import com.example.springbasicprinciple.member.Grade;
import com.example.springbasicprinciple.member.Member;
import com.example.springbasicprinciple.member.MemberService;
import com.example.springbasicprinciple.order.Order;
import com.example.springbasicprinciple.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        final OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        final Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
    }
}
