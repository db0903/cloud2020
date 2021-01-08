package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author db
 * @date 2021/1/4 - 14:39
 */
@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA") //一级目录可以检测到
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        //服务降级
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //log.info("testD 测试RT");
        log.info("异常比例");
        int age = 10/0;
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")  //唯一标识  //required = false 表示可以传值可以不传值
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2
                             ){
        //int age = 10/0;
        return "testHotKey异常测试";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o"; //兜底方法，改变sentinel 默认提示
    }
}


