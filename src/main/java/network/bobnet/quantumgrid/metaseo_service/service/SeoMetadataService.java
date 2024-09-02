package network.bobnet.quantumgrid.metaseo_service.service;

import lombok.AllArgsConstructor;
import network.bobnet.quantumgrid.metaseo_service.entity.SeoMetadata;
import network.bobnet.quantumgrid.metaseo_service.repository.SeoMetadataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SeoMetadataService {

    private final SeoMetadataRepository seoMetadataRepository;

    public SeoMetadata createSeoMetadata(SeoMetadata seoMetadata) {
        return seoMetadataRepository.save(seoMetadata);
    }

    public Optional<SeoMetadata> getSeoMetadataById(Long id) {
        return seoMetadataRepository.findById(id);
    }

    public List<SeoMetadata> getSeoMetadataByEntity(Long entityId, String entityType) {
        return seoMetadataRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public SeoMetadata updateSeoMetadata(SeoMetadata seoMetadata) {
        return seoMetadataRepository.save(seoMetadata);
    }

    public void deleteSeoMetadata(Long id) {
        seoMetadataRepository.deleteById(id);
    }
}
