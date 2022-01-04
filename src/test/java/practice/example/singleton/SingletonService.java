package practice.example.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // SingletonService 의 객체를 private static final 로 선언해서 하나만 존재하게끔 설계

    private SingletonService(){

    }
    public void logic () {
        System.out.println("싱글턴 객체 로직을 호출했다.");
    }

    public static SingletonService getInstance(){
        return instance;
    }





}
