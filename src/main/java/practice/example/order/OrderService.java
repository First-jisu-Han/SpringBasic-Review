package practice.example.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice );   // createOrder 를 통해 주문을 만든다.


}
