package com.cyzs.springboot.service;

import com.cyzs.springboot.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author xiaoH
 * @create 2019-05-09-0:02
 */
@Service
public class BookService {

    @RabbitListener(queues = "cyzs")
    public void receive(Book book){
        System.out.println("接收到消息"+book);
    }
}
