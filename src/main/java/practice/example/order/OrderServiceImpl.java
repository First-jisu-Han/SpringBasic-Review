package practice.example.order;

import practice.example.discount.DiscountPolicy;
import practice.example.discount.FixDiscountPolicy;
import practice.example.member.Grade;
import practice.example.member.Member;
import practice.example.member.MemberRepository;
import practice.example.member.MemoryMemeberRepository;

public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository = new MemoryMemeberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // memberRepository 에서 회원을 찾아야함 + discountPolicy 가 필요하다.
    // 그래야만 Order내역을 반환해 줄 수 있기 때문이다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 이렇게 만들어진 정보들을 클라이언트에 반환해 준다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
