package singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.example.AppConfig;
import practice.example.member.MemberService;

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
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
