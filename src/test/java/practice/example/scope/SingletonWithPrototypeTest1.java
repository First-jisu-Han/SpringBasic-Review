package practice.example.scope;

import ch.qos.logback.core.net.server.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {
    @Test

    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean pt= ac.getBean(PrototypeBean.class);
        pt.addCount();
        Assertions.assertThat(pt.getCount()).isEqualTo(1);

        PrototypeBean pt2=ac.getBean(PrototypeBean.class);
        pt2.addCount();
        Assertions.assertThat(pt2.getCount()).isEqualTo(1);  // 원래기대하는 프로토타입 사용으로 인한 1이지만 이미 생성된 객체를 나눠서 사용하기 때문에 2가 됨.


    }
    @Test
    void singltonClientIsePrototype(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);
        ClientBean cb1=ac.getBean(ClientBean.class);
        int count1= cb1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean cb2=ac.getBean(ClientBean.class);
        int count2= cb2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }

    @Scope("prototype")
    static class PrototypeBean{

        private int count = 0 ;

        public void addCount(){
            count++;
        }
        public int getCount() {
            return count;
        }
        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init: " + this);
        }
        @PreDestroy
        public void destroy(){
            System.out.println("ProtoTypeBean.destroy: "+ this);
        }
    }


    @Scope("singleton")
    static class ClientBean{
        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider; // javax.injection 쪽 라이브러리를 사용해야한다.

        public int logic(){
            PrototypeBean prototypeBean=prototypeBeanProvider.get(); // 프로토 타입 빈을 찾아서 반환
            int count= prototypeBean.getCount();
            return count;
        }
    }

}
