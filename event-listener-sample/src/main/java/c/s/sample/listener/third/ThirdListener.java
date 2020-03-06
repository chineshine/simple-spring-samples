package c.s.sample.listener.third;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.event.TransactionalEventListener;
//import org.springframework.transaction.support.TransactionSynchronizationAdapter;
//import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
//way.3
@Slf4j
@Component
public class ThirdListener {

	@EventListener
	public void listen(ThirdEvent event) {
		log.info(event.getSource().toString());
		log.info("第三个listener,time:" + event.getTimestamp());
	}

	/**
	 	关于监听器事务同步: 
	 	  方式1: 可采用注解 {@link TransactionalEventListener} 
	 	  方式2: 如下方式
	 */
//	@EventListener
//	public void transationListen(ThirdEvent event) {
//		if (TransactionSynchronizationManager.isActualTransactionActive()) {
//			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//				@Override
//				public void afterCommit() {
//					// you can do something here,such as sending an email.
//				}
//			});
//		}
//	}
}
