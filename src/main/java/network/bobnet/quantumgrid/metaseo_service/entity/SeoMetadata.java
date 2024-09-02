package network.bobnet.quantumgrid.metaseo_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seo_metadata")
public class SeoMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "canonical_url")
    private String canonicalUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
