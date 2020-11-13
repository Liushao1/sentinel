package com.ls.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @SentinelResource(value = "PersonGetBody1",blockHandler = "back1")
    public String getBody1() {

        return "liushao";
    }
    public String back1(BlockException e){

        return "getBody1方法没有资源可用了,被降级了！";
    }

    @SentinelResource(value = "PersonGetBody2",blockHandler = "back2")
    public String getBody2() {

        return "liushao";
    }
    public String back2(BlockException e){

        return "getBody2方法没有资源可用了,被降级了！";
    }
}
