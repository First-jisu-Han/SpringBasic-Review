package singleton;

public class StatefulService {
    // 무상태 유지가 중요함.

    private int price;
    public void order(String name,int price){
        this.price =price;   // 이게 싱글톤에서 문제가 된다.
    }

    public int getPrice () {
        return price;
    }
}
