package practice.example.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {
    @Test
    @DisplayName("싱글톤 패턴의 문제점 ")
    void statefulServiceSingleton(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1=ac.getBean("statefulService",StatefulService.class);
        StatefulService statefulService2=ac.getBean("statefulService",StatefulService.class);

        int userAPrice=statefulService1.order("UserA",10000);
        int userBProce=statefulService2.order("UserB",20000);

        System.out.println("userA의 지불비용= " + userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }
    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
