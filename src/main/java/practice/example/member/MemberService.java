package practice.example.member;

public interface MemberService {
    // 회원 서비스 - 회원 가입 , 회원 조회 기능 가지고 있어야함

    void join(Member member);

    Member findMember(Long memberId);
}
