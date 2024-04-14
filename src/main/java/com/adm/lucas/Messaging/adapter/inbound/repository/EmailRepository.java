package com.adm.lucas.Messaging.adapter.inbound.repository;

import com.adm.lucas.Messaging.adapter.inbound.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
}