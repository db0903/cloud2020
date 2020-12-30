package com.atguigu.springcloud.server.impl;

import com.atguigu.springcloud.server.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

/**
 * @author db
 * @date 2020/12/30 - 11:13
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send(){
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build()); //消息绑定器
        System.out.println("*****serial: "+serial);
        return null;
    }

}
