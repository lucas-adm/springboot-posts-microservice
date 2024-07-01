package com.adm.lucas.Messaging.adapter.inbound.service;

import com.adm.lucas.Messaging.adapter.inbound.entity.EmailEntity;
import com.adm.lucas.Messaging.adapter.inbound.entity.enums.Status;
import com.adm.lucas.Messaging.adapter.inbound.repository.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class EmailService {

    final EmailRepository emailRepository;
    final JavaMailSender emailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public void sendEmail(EmailEntity email) {
        try {
            email.setSendDateEmail(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
            email.setEmailFrom(emailFrom);

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");

            helper.setTo(email.getEmailTo());
            helper.setSubject(email.getSubject());
            helper.setFrom(emailFrom);

            helper.setText(email.getText(), true);

            emailSender.send(message);
            email.setStatus(Status.SENT);
        } catch (MailException | MessagingException e) {
            email.setStatus(Status.ERROR);
        } finally {
            emailRepository.save(email);
        }
    }

    @Transactional
    public void sendRecoverEmail(EmailEntity email) {
        try {
            email.setSendDateEmail(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
            email.setEmailFrom(emailFrom);

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");

            helper.setTo(email.getEmailTo());
            helper.setSubject(email.getSubject());
            helper.setFrom(emailFrom);

            helper.setText(email.getText(), true);

            emailSender.send(message);
            email.setStatus(Status.SENT);
        } catch (MailException | MessagingException e) {
            email.setStatus(Status.ERROR);
        } finally {
            emailRepository.save(email);
        }
    }

}