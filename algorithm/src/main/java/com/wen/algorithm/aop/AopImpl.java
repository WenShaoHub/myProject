package com.wen.algorithm.aop;

import org.springframework.stereotype.Component;

@Component
public class AopImpl {

    public void cutPoint(){
        System.out.println("======run cutpoint()====");
    }
}
