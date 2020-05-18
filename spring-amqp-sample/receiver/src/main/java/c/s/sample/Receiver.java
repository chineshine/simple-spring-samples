package c.s.sample;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

/**
 * rabbitmq 消息接收器
 * @author chineshine
 * @since  2020年3月13日
 */
@Component
public class Receiver {
	
	private CountDownLatch latch = new CountDownLatch(1);

	  public void receiveMessage(String message) {
	    System.out.println("Received <" + message + ">");
	    latch.countDown();
	  
	  }

	  public CountDownLatch getLatch() {
	    return latch;
	  }

}
