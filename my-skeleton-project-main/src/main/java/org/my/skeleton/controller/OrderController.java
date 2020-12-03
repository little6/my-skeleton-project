package org.my.skeleton.controller;

import org.my.skeleton.biz.OrderBiz;
import org.my.skeleton.client.common.Response;
import org.my.skeleton.client.common.ResponseCode;
import org.my.skeleton.exception.BizException;
import org.my.skeleton.exception.ParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderBiz orderBiz;

    @RequestMapping("/close")
    public Response<Void> closeOrder(Long orderId){
        try {
            if(orderId == null || orderId < 1){
                throw new ParamException("订单id不合法");
            }
            orderBiz.closeOrder(orderId);
            return Response.success(null);
        }catch (ParamException e){//参数异常
            return new Response<>(ResponseCode.PARAM_ERROR,e.getMessage());
        }catch (BizException e){//业务异常
            return new Response<>(ResponseCode.BIZ_EXCEPTION,e.getMessage());
        }catch (Exception e){//保证任何异常都能被捕获
            LOGGER.error("关闭订单时发生异常：",e);
            return new Response<>(ResponseCode.SERVER_ERROR,"服务端开小差，请稍后重试!");
        }
    }
}
