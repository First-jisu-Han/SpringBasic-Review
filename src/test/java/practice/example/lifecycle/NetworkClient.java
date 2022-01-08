package practice.example.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 , url = " + url);
    }

    public void setUrl(String url){
        this.url=url;
    }

    public void connect(){
        System.out.println("connet : " +url);
    }
    public void call(String message){
        System.out.println("call :" + url + "message" +message);
    }

    public void disconnect() {
        System.out.println("close = " + url);
    }


    // 빈 초기화가 완료된 후 알려줌
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    // 빈 종료 전에 알려줌
    @Override
    public void destroy() throws Exception {
        disconnect();
    }

}
