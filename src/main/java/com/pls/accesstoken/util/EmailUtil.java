package com.pls.accesstoken.util;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by 81046 on 2018-07-20
 */
@Component
public class EmailUtil {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    JavaMailSender mailSender;

    public void sendSimpleEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content) throws ServiceException {
        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send mail ... ");
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(deliver);
            message.setTo(receiver);
            message.setCc(carbonCopy);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            logger.info("Send mail success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MailException e) {
            logger.error("Send mail failed, error message is : {} \n", e.getMessage());
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

}
