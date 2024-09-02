package network.bobnet.quantumgrid.metaseo_service.repository;

import network.bobnet.quantumgrid.metaseo_service.entity.SeoMetadata;
import network.bobnet.quantumgrid.metaseo_service.enums.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeoMetadataRepository extends JpaRepository<SeoMetadata, Long> {

    List<SeoMetadata> findByEntityIdAndEntityType(Long entityId, EntityType entityType);
}
