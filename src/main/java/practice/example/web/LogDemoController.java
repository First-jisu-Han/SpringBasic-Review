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
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody  // http의 헤더부분과 body부분 중 body 부분 -> 바디부에 데이터를 내려줌
    // HttpServletRequest 를 통해서 요청 URL을 받음
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logService.logic("testID");
        return "OK";
    }


}
