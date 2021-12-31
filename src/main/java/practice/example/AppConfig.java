package practice.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.example.discount.DiscountPolicy;
import practice.example.discount.FixDiscountPolicy;
import practice.example.discount.RateDiscountPolicy;
import practice.example.member.MemberRepository;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;
import practice.example.member.MemoryMemberRepository;
import practice.example.order.OrderService;
import practice.example.order.OrderServiceImpl;



// 스프링을 이용해서 AppConfig 를 설정하는 방법이다.
// @Configuration 어노테이션을 통해서 구성 정보임을 알리고, @Bean 을 통해서 스프링 컨테이너에 스프링 빈으로 등록을 한다.
// @Configuration + @Bean

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                discountPolicy(),memberRepository());
    }
}
