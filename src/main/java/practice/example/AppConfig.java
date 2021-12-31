package practice.example;

import practice.example.discount.DiscountPolicy;
import practice.example.discount.FixDiscountPolicy;
import practice.example.member.MemberRepository;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;
import practice.example.member.MemoryMemberRepository;
import practice.example.order.OrderService;
import practice.example.order.OrderServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                discountPolicy(),memberRepository());
    }


}
