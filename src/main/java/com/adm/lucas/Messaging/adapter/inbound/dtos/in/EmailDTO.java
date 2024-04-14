package com.adm.lucas.Messaging.adapter.inbound.dtos.in;

import com.adm.lucas.Messaging.adapter.inbound.entity.EmailEntity;

import java.util.UUID;

public record EmailDTO(
        UUID id,
        String emailTo,
        String subject,
        String text
) {
    public EmailEntity toEmail() {
        return new EmailEntity(id, emailTo, subject, text);
    }
}