package singleton;

public class StatefulService {
    // 무상태 유지가 중요함.

//    private int price;

    public int order(String name,int price){
        System.out.println("name = " + name + "price = "+price);
        return price;
    }

}
