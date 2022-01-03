package practice.example.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import practice.example.member.MemberRepository;
import practice.example.member.MemoryMemberRepository;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {

    ApplicationContext ac= new AnnotationConfigApplicationContext(NewConfig.class);
    @Test
    @DisplayName("동일한 두 타입의 빈 조회 - 중복 오류 발생")
    void findByTypeEqual(){
//        MemberRepository memberRepository=ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class , () -> ac.getBean(MemberRepository.class));

    }

    @Test
    @DisplayName("동일한 두 타입의 빈 조회 - 이름 설정하면 중복 오류 피할 수 있음")
    void findByTypeEqualMakeNames(){
        MemberRepository memberRepository=ac.getBean("memberRepository1",MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }


    @Configuration
    static class NewConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

    }
}
