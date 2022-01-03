package singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AppConfig;
import practice.example.member.MemberRepository;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;
import practice.example.order.OrderService;
import practice.example.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("동시에 주입되는 클래스의 객체가 싱글톤을 유지할 수 있는지-> 유지한다.")
    void configurationTest(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService =ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService= ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository3 = ac.getBean("memberRepository",MemberRepository.class);

        MemberRepository memberRepository1=memberService.getMemberRepository();
        MemberRepository memberRepository2=orderService.getMemberRepository();


        System.out.println("memberService --> memberRepository= " + memberRepository1);
        System.out.println("orderService --> memberRepository= " + memberRepository2);
        System.out.println("memberRepository -->memberRepository3 = " + memberRepository3);

        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository3);
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository3);
        /* 출력 결과 :
        주입된 객체는 주소값이 같은 완전히 값은 값이다 : 싱글톤 유지

       memberService --> memberRepository= practice.example.member.MemoryMemberRepository@60957c0f
       orderService --> memberRepository= practice.example.member.MemoryMemberRepository@60957c0f
       memberRepository -->memberRepository3 = practice.example.member.MemoryMemberRepository@60957c0f

         */
    }
    @Test
    void configurationDeep(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // AppConfig 클래스가 아니라 똑같은 임의의 다른 클래스 AppCofig@CGLIB ... 을 스프링 컨테이너에 등록
    }


}
