package c.s.sample;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import c.s.sample.config.Receiver;

/**
 * @author chineshine
 * @since  2020年5月19日
 */
@Component
public class Runner implements CommandLineRunner {

	static final String topicExchangeName = "topicExchange1";

	private final Receiver receiver;

	public Runner(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}

}