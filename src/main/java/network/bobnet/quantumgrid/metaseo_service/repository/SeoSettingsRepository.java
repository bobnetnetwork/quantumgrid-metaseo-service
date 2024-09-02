package network.bobnet.quantumgrid.metaseo_service.repository;

import network.bobnet.quantumgrid.metaseo_service.entity.SeoSettings;
import network.bobnet.quantumgrid.metaseo_service.enums.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeoSettingsRepository extends JpaRepository<SeoSettings, Long> {

    Optional<SeoSettings> findByEntityType(EntityType entityType);
}
