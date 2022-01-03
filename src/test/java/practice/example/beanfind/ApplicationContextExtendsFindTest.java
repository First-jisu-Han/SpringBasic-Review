package practice.example.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.example.discount.DiscountPolicy;
import practice.example.discount.FixDiscountPolicy;
import practice.example.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);


    @Test
    @DisplayName("부모타입으로 조회시 , 자식이 둘 이상 있으면 중복오류가 발생한다. ")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으먼 , 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf((RateDiscountPolicy.class));
    }
    @Test
    @DisplayName(" 부모 타입으로 모두 조회")
    void findAllBeanByParent(){
        Map<String,DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key+ "value = " +beansOfType.get(key));
        }
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeansByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
    }
    @Test
    @DisplayName("빈 설정 메타데이터 읽기")
    void findApplicationBean(){
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitonName = " + beanDefinitionName+ "beanDefinition =" +
                        beanDefinition);
            }
        }

    }





    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }


}

