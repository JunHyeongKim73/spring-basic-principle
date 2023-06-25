package com.example.springbasicprinciple.order;

import com.example.springbasicprinciple.discount.DiscountPolicy;
import com.example.springbasicprinciple.discount.FixDiscountPolicy;
import com.example.springbasicprinciple.member.Member;
import com.example.springbasicprinciple.member.MemberRepository;
import com.example.springbasicprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        final int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
