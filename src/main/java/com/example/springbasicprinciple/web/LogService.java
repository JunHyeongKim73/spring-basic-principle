package com.example.springbasicprinciple.web;

import com.example.springbasicprinciple.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final ObjectProvider<MyLogger> provider;

    public void logic(String id) {
        final MyLogger myLogger = provider.getObject();
        myLogger.log("service id = " + id);
    }
}
