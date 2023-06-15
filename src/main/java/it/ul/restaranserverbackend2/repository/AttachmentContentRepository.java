package it.ul.restaranserverbackend2.repository;

import it.ul.restaranserverbackend2.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    AttachmentContent findByAttachmentId(UUID id);

}
