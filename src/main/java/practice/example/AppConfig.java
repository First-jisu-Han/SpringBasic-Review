package practice.example;

import practice.example.discount.FixDiscountPolicy;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;
import practice.example.member.MemoryMemeberRepository;
import practice.example.order.OrderService;
import practice.example.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemeberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new FixDiscountPolicy(),new MemoryMemeberRepository());
    }


}
