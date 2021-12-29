package practice.example.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // DIP / OCP 지금 위반중 - memberService 인터페이스에도 의존, MemberServiceImpl 구현체에도 의존중

    // Dependency Inversion Principal : 의존관계 역전 : 인터페이스에 의존해야지 ,구현체에 의존하면 안된다.
    // Open,Closed principal : 확장에는 열려있고, 변경에는 닫혀있어야한다 - 구현체는 확장해서 갈아 끼울 수 있어야 하고, 코드 변경을 통해서 구현체를 갈아끼우면 안된다.
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){

        //given - 이런 환경에서  - 이런 맴버가 있을때
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when  - 이렇게 했을때 -  멤버 서비스에 가입을 할때
        memberService.join(member);
        Member findMember=memberService.findMember(1L);

        //then  - 이렇게 된다.- 추가한 멤버정보와 찾은 멤버가 같다면 테스트 성공된다.
        Assertions.assertThat(member).isEqualTo(findMember);



    }

}
