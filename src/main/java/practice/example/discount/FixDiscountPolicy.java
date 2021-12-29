package practice.example.discount;

import practice.example.member.Grade;
import practice.example.member.Member;

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
