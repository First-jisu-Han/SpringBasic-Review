package practice.example;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type= FilterType.ANNOTATION,classes=Configuration.class))
// @Configuration 붙은 것 모두 제외하고 컴포넌트 스캔 -> AppConfig의 @configuration 붙은 것들까지 모두 빈으로 등록하면 충돌을 유발할 수 있기 때문이다.
// 보통은 그냥 @ComponetScan 을 사용하는데, AppConfig.class 를 남겨놓기 위한 장치이다.

public class AutoAppConfig {
    
}
