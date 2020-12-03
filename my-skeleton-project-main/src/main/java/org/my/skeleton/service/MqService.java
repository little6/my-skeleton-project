package org.my.skeleton.service;

import org.springframework.stereotype.Service;

@Service
public class MqService {
    public void sendOrderClosedMsg(long orderId,String msg){
        //构建消息体
        //调用mq客户端发消息
        System.out.println("发送消息");
    }
}
