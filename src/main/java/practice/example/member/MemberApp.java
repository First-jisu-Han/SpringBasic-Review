package practice.example.member;


import practice.example.AppConfig;

// 자바 코드로 테스트 해본다
public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig= new AppConfig();
        MemberService memberService=appConfig.memberService();

//        MemberService memberService= new MemberServiceImpl();

        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
