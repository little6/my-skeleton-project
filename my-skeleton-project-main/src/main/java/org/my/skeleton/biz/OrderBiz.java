package org.my.skeleton.biz;

import org.my.skeleton.exception.BizException;
import org.my.skeleton.service.MqService;
import org.my.skeleton.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderBiz {
    @Resource
    private OrderService orderService;
    @Resource
    private MqService mqService;

    public void closeOrder(long id)throws Exception{
        //判断订单是否存在
        if(!orderService.isExist(id)){
            throw new BizException("订单不存在!");
        }
        //关闭订单
        orderService.closeOrder(id);
        //发送订单关闭消息
        mqService.sendOrderClosedMsg(id,"订单已关闭");
    }
}
