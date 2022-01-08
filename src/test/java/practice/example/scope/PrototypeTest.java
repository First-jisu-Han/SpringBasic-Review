package practice.example.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println("find prototypeBean1");
        ProtoTypeBean pt1 = ac.getBean(ProtoTypeBean.class);
        System.out.println("find prototypeBean2");
        ProtoTypeBean pt2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("pt1 = " + pt1);
        System.out.println("pt2 = " + pt2);

        ac.close();
    }


    // @Component 를 등록하지 않아도, new AnnotationApplicationContext(PrototypeBean.class) 자체가 컴포넌트 스캔처럼 등록되기 때문에 없어도 스프링 컨테이너의 빈으로 등록되는 것.
    @Scope("prototype")
    static class ProtoTypeBean {

        @PostConstruct
        public void init() {
            System.out.println(" ProtoTypeBean.init ");
        }

        @PreDestroy
        public void destroy() {
            System.out.println(" ProtoTypeBean.destroy");
        }
    }
}
