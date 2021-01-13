package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author db
 * @date 2021/1/8 - 16:04
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444,"按客戶自定义----1");
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"按客戶自定义----2");
    }




}
