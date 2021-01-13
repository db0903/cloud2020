package com.atguigu.springcloud.alibaba.service;


import org.springframework.stereotype.Service;

/**
 * @author db
 * @date 2021/1/12 - 15:24
 */
public interface StorageService {
    //扣减库存信息
    void decrease(Long productId, Integer count);
}
