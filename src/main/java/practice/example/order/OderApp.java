package practice.example.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AppConfig;
import practice.example.AutoAppConfig;
import practice.example.member.Grade;
import practice.example.member.Member;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;


public class OderApp {
    public static void main(String[] args) {
        /*
        AppConfig appConfig= new AppConfig();
        MemberService memberService=appConfig.memberService();
        // 하는 순간 생성자에 값이 넣어져서 - 의존성주입이 안료됨

        OrderService orderService=appConfig.orderService();
        // 하는 순간 생성자에 값이 넣어져서 - 의존성주입이 안료됨

        */
        // Spring 컨테이너를 사용할 것 - 의존관계 환경설정한 AppConfig.class 안의 @Bean을 스프링 컨테이너에 모두 집어넣는다. ApplicationContext 가 스프링 컨테이너이다.
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =applicationContext.getBean("memberService",MemberService.class);  // 스프링 컨테이너 안에 등록된 빈- 설정정보를 getBean을 통해서 가져온다.
        OrderService orderService =applicationContext.getBean("orderService",OrderService.class); // 스프링 컨테이너 안에 등록된 빈- 설정정보를 getBean을 통해서 가져온다.


        Long memberId= 1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);  // 멤버생성
        memberService.join(member);   // 멤버 등록해놓고

        Order order =orderService.createOrder(memberId,"지우개",10000);
        System.out.println("order = " + order);
        // oder = Order{memberId= 1,itemName= 지우개, itemPrice= 10000', discountPrice= 1000}
        System.out.println(order.calculatePrice());
        // 9000



    }
}
