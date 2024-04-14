package com.adm.lucas.Messaging.adapter.outbound.consumers;

import com.adm.lucas.Messaging.adapter.inbound.dtos.in.EmailDTO;
import com.adm.lucas.Messaging.adapter.inbound.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService service;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO dto) {
        var email = dto.toEmail();
        service.sendEmail(email);
    }

}