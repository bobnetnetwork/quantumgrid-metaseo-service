package network.bobnet.quantumgrid.metaseo_service.service;

import network.bobnet.quantumgrid.metaseo_service.entity.SeoSettings;
import network.bobnet.quantumgrid.metaseo_service.enums.EntityType;
import network.bobnet.quantumgrid.metaseo_service.repository.SeoSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeoSettingsService {

    private final SeoSettingsRepository seoSettingsRepository;

    @Autowired
    public SeoSettingsService(SeoSettingsRepository seoSettingsRepository) {
        this.seoSettingsRepository = seoSettingsRepository;
    }

    public Optional<SeoSettings> getSeoSettingsByEntityType(EntityType entityType) {
        return seoSettingsRepository.findByEntityType(entityType);
    }

    public SeoSettings updateSeoSettings(SeoSettings seoSettings) {
        return seoSettingsRepository.save(seoSettings);
    }
}
