package com.adm.lucas.Messaging.adapter.inbound.service;

import com.adm.lucas.Messaging.adapter.inbound.entity.EmailEntity;
import com.adm.lucas.Messaging.adapter.inbound.entity.enums.Status;
import com.adm.lucas.Messaging.adapter.inbound.repository.EmailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    public EmailEntity sendEmail(EmailEntity email) {
        try {
            email.setSendDateEmail(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            emailSender.send(message);
            email.setStatus(Status.SENT);
        } catch (MailException e) {
            email.setStatus(Status.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }

}