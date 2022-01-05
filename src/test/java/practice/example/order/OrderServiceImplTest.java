package practice.example.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.example.discount.FixDiscountPolicy;
import practice.example.member.Grade;
import practice.example.member.Member;
import practice.example.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService=new OrderServiceImpl(new FixDiscountPolicy(),memberRepository);
        Order order=orderService.createOrder(1L,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
