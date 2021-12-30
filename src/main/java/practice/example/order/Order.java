package practice.example.order;

// 주문

public class Order {
    private Long memberId;      // 회원 아이디
    private String itemName;    // 주문 품목이름
    private int itemPrice;      // 주문 금액
    private int discountPrice;  // 할인 금액

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    // getter setter 설정 - 자바 빈 규약

    public int calculatePrice(){
        return itemPrice-discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    // 주문 객체 마다 주소값을 반환하지말고, 주문의 내역을 반환하도록 toString() 을 오버라이드하여 재정의 한다.

    @Override
    public String toString() {
        return "Order{" + "memberId= " + memberId +
                ",itemName= " + itemName +
                ", itemPrice= " + itemPrice + '\'' +
                ", discountPrice= " + discountPrice +
                "}";
    }

}

