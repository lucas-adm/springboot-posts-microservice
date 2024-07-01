package com.adm.lucas.Messaging.adapter.inbound.dtos.in;

import com.adm.lucas.Messaging.adapter.inbound.entity.EmailEntity;

public record RecoverDTO(
        String emailTo,
        String subject,
        String text
) {
    public EmailEntity toEmail() {
        return new EmailEntity(emailTo, subject, text);
    }
}