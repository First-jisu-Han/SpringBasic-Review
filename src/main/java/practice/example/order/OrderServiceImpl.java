package practice.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.example.discount.DiscountPolicy;
import practice.example.member.Member;
import practice.example.member.MemberRepository;
import practice.example.member.MemoryMemberRepository;

// OrderServiceImpl은 주문서비스만 집중하도록 - AppConfig에서 필요한 것들을 다룬다.

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemeberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy=new RateDiscountPolicy();
    // OCP 의 위반 -> 주문 서비스의 코드를 변경해야하는 문제가 발생하게 됨.
    // DIP 도 위반 -> 인터페이스에도 의존, 구현체에도 의존하고 있는 문제.

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    // DiscountPolicy의 구현체 와 MemberRepository의 구현체 가 필요함.

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository=memberRepository;
//    }

    @Autowired
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }


    // 따라서- 구현체에만 의존하도록 DIP / OCP 지키도록 코드를 변경함 -> 이렇게 사용하면 NullPointerException이 생긴다.
     // 구현객체를 대신 생성하고 주입할 필요성이 생긴다.

    // memberRepository 에서 회원을 찾아야함 + discountPolicy 가 필요하다.
    // 그래야만 Order내역을 반환해 줄 수 있기 때문이다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 이렇게 만들어진 정보들을 클라이언트에 반환해 준다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Test 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
