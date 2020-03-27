package c.s.sample.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @since  2020年3月27日
 */
@RestController
public class I18nController {

	private @Autowired MessageSource messageSource;

	@GetMapping("/i18n")
	public String msg(String language) {
		if ("cn".equals(language)) {
			return messageSource.getMessage("sample.hello", null, Locale.CHINESE);
		}
		if ("en".equals(language)) {
			return messageSource.getMessage("sample.hello", null, Locale.ENGLISH);
		}
		return "hello,i18n";
	}
}
