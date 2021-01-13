package com.atguigu.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @author db
 * @date 2021/1/12 - 15:17
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

