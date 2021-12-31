package practice.example.member;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.example.AppConfig;

// 자바 코드로 테스트 해본다
public class MemberApp {
    public static void main(String[] args) {
//
//        AppConfig appConfig= new AppConfig();
//        MemberService memberService=appConfig.memberService();

        /* 스프링의 사용 - ApplicationContext - 스프링 컨테이너 -> @Configuration 이 붙은 AppConfig 를 설정 정보호 사용한다. @Bean 은
        이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록 -> 스프링 컨테이너에 등록된 객체들은 스프링 빈이라고 한다.


         */
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
//        MemberService memberService= new MemberServiceImpl();

        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
