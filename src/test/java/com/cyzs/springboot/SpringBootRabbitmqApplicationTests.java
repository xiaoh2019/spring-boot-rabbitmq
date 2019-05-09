package com.cyzs.springboot;

import com.cyzs.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void admin(){
		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin"));
		//创建消息队列
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin","amqpadmin.queue",null));
	}

	@Test
	public void contextLoads() {
		//rabbitTemplate.send();
		//object对象自动序列化转给rabbitmq
		Map<String,Object> map = new HashMap<>();
		map.put("msg","第一条消息");
		map.put("data", Arrays.asList("王二","wang@qq.com"));
		rabbitTemplate.convertAndSend("exchange-direct","cyzs",map);

	}

	@Test
	public void sent() {

		rabbitTemplate.convertAndSend("exchange-direct","cyzs",new Book("三国演义","罗贯中"));

	}
	@Test
	public void receive(){
		Object cyzs = rabbitTemplate.receiveAndConvert("cyzs");
		System.out.println(cyzs.getClass()+"===========");
		System.out.println(cyzs+"==========");
	}

}
