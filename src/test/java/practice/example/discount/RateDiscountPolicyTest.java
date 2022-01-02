package practice.example.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.example.member.Grade;
import practice.example.member.Member;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인이 제대로 적용되는지 확인")
    void vip_o(){
        // given
        Member member= new Member(1L,"한지수", Grade.VIP);
        // when
        int discount =rateDiscountPolicy.discount(member,10000);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP가 아닐때에는 할인 실패해야한다")
    void vip_x(){
        // given
        Member member= new Member(1L,"한지수", Grade.BASIC);
        // when
        int discount =rateDiscountPolicy.discount(member,10000);
        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }



}