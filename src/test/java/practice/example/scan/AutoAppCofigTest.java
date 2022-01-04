package practice.example.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AutoAppConfig;
import practice.example.member.MemberService;

public class AutoAppCofigTest {
    ApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class);


    @Test
    void basicScan(){
        MemberService memberService=ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }




}
