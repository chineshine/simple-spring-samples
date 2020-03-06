package c.s.sample.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author chineshine
 * @since  2020年3月6日
 */
@Service
public class MailSendService {

	private @Autowired MailProperties mailProperties;
	
	private @Autowired JavaMailSender javaMailSender;

	public void send(Mail mail) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(mailProperties.getUsername());
		helper.setSubject(mail.getSubject());
		helper.setTo(mail.getTo());
		// 是否发送 html 内容
		helper.setText(mail.getContent(), true);
		javaMailSender.send(mimeMessage);
	}
}
