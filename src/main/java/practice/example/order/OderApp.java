package practice.example.order;

import practice.example.AppConfig;
import practice.example.member.Grade;
import practice.example.member.Member;
import practice.example.member.MemberService;
import practice.example.member.MemberServiceImpl;


public class OderApp {
    public static void main(String[] args) {
        AppConfig appConfig= new AppConfig();
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();

        Long memberId= 1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);  // 멤버생성
        memberService.join(member);   // 멤버 등록해놓고

        Order order =orderService.createOrder(memberId,"지우개",10000);
        System.out.println("order = " + order);
        // oder = Order{memberId= 1,itemName= 지우개, itemPrice= 10000', discountPrice= 1000}
        System.out.println(order.calculatePrice());
        // 9000



    }
}
