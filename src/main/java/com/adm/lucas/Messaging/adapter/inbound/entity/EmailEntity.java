package com.adm.lucas.Messaging.adapter.inbound.entity;

import com.adm.lucas.Messaging.adapter.inbound.entity.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "emails")
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;

    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    private Status status;

    public EmailEntity(UUID userId, String emailTo, String subject, String text) {
        this.userId = userId;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public EmailEntity(String emailTo, String subject, String text) {
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

}