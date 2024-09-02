package network.bobnet.quantumgrid.metaseo_service.entity;

import jakarta.persistence.*;
import lombok.*;
import network.bobnet.quantumgrid.metaseo_service.enums.ChangeFrequency;
import network.bobnet.quantumgrid.metaseo_service.enums.EntityType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seo_settings")
public class SeoSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false, unique = true)
    private EntityType entityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "changefreq", length = 20)
    private ChangeFrequency changefreq;

    @Column(name = "priority", length = 5)
    private String priority; // ("0.5", "0.8")
}
