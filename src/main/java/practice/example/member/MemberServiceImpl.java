package practice.example.member;

// 구현체가 하나일때는 보통 Impl 이라고 사용하는 관례

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemeberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
