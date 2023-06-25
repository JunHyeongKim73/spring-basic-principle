package com.example.springbasicprinciple.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
