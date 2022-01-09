package practice.example.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.example.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogService logService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    // HttpServletRequest 를 통해서 요청 URL을 받음
    public String logDemo(HttpServletRequest request){
        MyLogger myLogger=myLoggerProvider.getObject();  // 필요한 시점인 이때 Provider를 통해서 주입받는다. 
        String requestURL = request.getRequestURI().toString();
        // 이렇게 받은 requestURL값을 mtLogger에 저장한다. myLoggerㄴ는 HTTP 요청당 각각 구분되므로, 다른 HTTP 요청때문에 값이 섞일 일 없다.
        myLogger.setRequestURL(requestURL);
        // 컨트롤러에서 controller test라는 로그를 남긴다.
        myLogger.log("controller test");
        logService.logic("testID");
        return "OK";
    }


}
