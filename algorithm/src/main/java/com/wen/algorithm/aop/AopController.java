package com.wen.algorithm.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/aop")
public class AopController {

    AopImpl aopImpl;

    public static void main(String[] args) {
        System.out.println("323232");
    }
    @RequestMapping("/testCut")
    public void testCut(){
        System.out.println("=====testCut====");
    }



}
