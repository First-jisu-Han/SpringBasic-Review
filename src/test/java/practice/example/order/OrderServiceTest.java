package practice.example.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.example.member.Grade;
import practice.example.member.Member;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;

public class OrderServiceTest {
    @Test
    void createOrder() {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl(); // OrderService 는 같은 패키지에 있기 때문에 import 하지 않아도된다.

        Member member=new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Order order =orderService.createOrder(1L,"지우개",10000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);

    }
}
