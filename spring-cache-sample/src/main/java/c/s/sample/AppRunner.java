package c.s.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import c.s.sample.repository.IDictRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 运行 main 方法,测试功能
 * @author chineshine
 * @since  2020年3月26日
 */
@Slf4j
@Component
public class AppRunner implements CommandLineRunner{

	private @Autowired IDictRepository dictRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info(dictRepository.getDictByNameCache("dict1").getName());
		log.info(dictRepository.getDictByNameCache("dict1").getName());
		log.info(dictRepository.getDictByNameCache("dict1").getName());
		log.info(dictRepository.getDictByNameCache("dict2").getName());
		log.info("-------------------------------");
		log.info(dictRepository.getDictByNameNotCache("dict1").getName());
		log.info(dictRepository.getDictByNameNotCache("dict1").getName());
		log.info(dictRepository.getDictByNameNotCache("dict1").getName());
		log.info(dictRepository.getDictByNameNotCache("dict2").getName());
	}

}
