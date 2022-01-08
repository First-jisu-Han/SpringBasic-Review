package practice.example.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean sb1 =ac.getBean(SingletonBean.class);
        SingletonBean sb2 =ac.getBean(SingletonBean.class);
        System.out.println("sb1 = " + sb1);
        System.out.println("sb2 = " + sb2);

        ac.close();

    }

    @Scope("singleton")  // 디폴트 값이라서 생략가능하다.
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println(" SingletonBean.init ");
        }

        @PreDestroy
        public void destroy(){
            System.out.println(" SingletonBean.destroy");
        }
    }
}
