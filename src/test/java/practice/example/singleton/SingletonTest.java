package practice.example.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AppConfig;
import practice.example.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너 ")
    void pureContainer(){
        AppConfig appConfig= new AppConfig();

        MemberService memberService1=appConfig.memberService();
        MemberService memberService2=appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2 객체와 다름 - 계속 다른 객체를 생성해서 요청에 응답 - 싱글톤 패턴을 사용해야 한다.
        assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용 테스트 ")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너는 싱글톤으로 관리된다.")
    void springContainer(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1=ac.getBean("memberService",MemberService.class);
        MemberService memberService2=ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        
        Assertions.assertThat(memberService1).isSameAs(memberService2); 
    }
}
