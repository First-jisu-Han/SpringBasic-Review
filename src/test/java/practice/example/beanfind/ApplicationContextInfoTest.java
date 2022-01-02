package practice.example.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AppConfig;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextInfoTest {
    
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class); 
    
    @Test
    @DisplayName("모든 등록된 스프링 빈 출력해보기")
    void findAllBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName:beanDefinitionNames){
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName+"Object"+bean);
        }
    }

    @Test
    @DisplayName("사용자가 등록한 스프링 빈 출력해보기")
    void findApplicationRoleBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // BeanDefinition.ROLE_INFRASTRUCTURE  : 스프링 내부에서 사용하는 빈 , 아래는 직접 등록한 애플리케이션 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinition = " + beanDefinition);
            }
        }
    }
    @Test
    @DisplayName("빈 이름으로 조회 ")
    void findBeanByName(){
        MemberService memberService=ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름없이 빈 타입으로 조회 ")
    void findBeanByType(){
        MemberService memberService=ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
