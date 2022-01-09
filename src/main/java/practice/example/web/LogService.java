package practice.example.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import practice.example.common.MyLogger;


@Service
@RequiredArgsConstructor

public class LogService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id= "+id);
    }


}
