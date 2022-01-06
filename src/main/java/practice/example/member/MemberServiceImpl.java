package practice.example.member;

// 구현체가 하나일때는 보통 Impl 이라고 사용하는 관례

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    // 인터페이스만 의존중


    @Autowired  // ac.getBean(MemberRepository.class) 와 같은 느낌으로 동작 - new MemoryMemberRepository를 주입해준다.
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }


    // 생성자를 통해서 DIP / OCP 지키도록 설계
//    private final MemberRepository memberRepository = new MemoryMemeberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
