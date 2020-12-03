package org.my.skeleton.service;

import org.my.skeleton.dao.entity.OrderEntity;
import org.my.skeleton.dao.mapper.OrderEntityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderEntityMapper orderEntityMapper;


    public boolean isExist(long id) {
        OrderEntity orderEntity = orderEntityMapper.selectByPrimaryKey(id);
        return orderEntity != null;
    }

    public void closeOrder(long id) {
        OrderEntity entity =  new OrderEntity();
        entity.setId(id);
        entity.setStatus(1);
        orderEntityMapper.updateByPrimaryKey(entity);
    }
}
