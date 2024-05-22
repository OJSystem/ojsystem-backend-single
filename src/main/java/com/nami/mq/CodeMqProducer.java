package com.nami.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Mq 生产者
 *
 * @author nami
 */
@Component
public class CodeMqProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者发送消息
     *
     * @param exchange   发送消息到指定交换机
     * @param routingKey 消息标识
     * @param message    消息内容
     */
    public void sendMessage(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
