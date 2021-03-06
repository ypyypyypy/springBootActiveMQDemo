package cn.ypy.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 消息生产者
 * @author Administrator
 *
 */
@RestController
public class QueueController {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@RequestMapping("/send")
	public void send(String text){
	    text="你好";
		jmsMessagingTemplate.convertAndSend("zuma", text);
	}
	
	
	@RequestMapping("/sendmap")
	public void sendMap(){
		Map map=new HashMap<>();
		map.put("mobile", "13683391759");
		map.put("template_code", "SMS_86640114");
		map.put("sign_name","杨门");
		map.put("param", "{\"name\":\"小杨\"}");
		
		jmsMessagingTemplate.convertAndSend("zumasms", map);
	}
}
