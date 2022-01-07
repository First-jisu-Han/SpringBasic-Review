package practice.example.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import practice.example.annotation.MainDiscountPolicy;
import practice.example.member.Grade;
import practice.example.member.Member;


//@Qualifier("mainDiscountPolicy")         //  @Qualifier("mainDiscountPolicy") 는 타입 체크가 안되는 문제가 있다. 애노테이션을 만들어본다.
@Component
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{


    private static final int discountFixAmount = 1000;    //  1000원 고정 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
