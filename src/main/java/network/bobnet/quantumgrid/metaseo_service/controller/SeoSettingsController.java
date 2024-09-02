package network.bobnet.quantumgrid.metaseo_service.controller;

import network.bobnet.quantumgrid.metaseo_service.entity.SeoSettings;
import network.bobnet.quantumgrid.metaseo_service.enums.ChangeFrequency;
import network.bobnet.quantumgrid.metaseo_service.enums.EntityType;
import network.bobnet.quantumgrid.metaseo_service.service.SeoSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/seo/settings")
public class SeoSettingsController {

    private final SeoSettingsService seoSettingsService;

    @Autowired
    public SeoSettingsController(SeoSettingsService seoSettingsService) {
        this.seoSettingsService = seoSettingsService;
    }

    @GetMapping("/{entityType}")
    public ResponseEntity<SeoSettings> getSeoSettingsByEntityType(@PathVariable EntityType entityType) {
        Optional<SeoSettings> seoSettings = seoSettingsService.getSeoSettingsByEntityType(entityType);
        return seoSettings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{entityType}")
    public ResponseEntity<SeoSettings> updateSeoSettings(
            @PathVariable EntityType entityType,
            @RequestParam ChangeFrequency changefreq,
            @RequestParam String priority) {

        Optional<SeoSettings> seoSettingsOpt = seoSettingsService.getSeoSettingsByEntityType(entityType);
        if (seoSettingsOpt.isPresent()) {
            SeoSettings seoSettings = seoSettingsOpt.get();
            seoSettings.setChangefreq(changefreq);
            seoSettings.setPriority(priority);
            SeoSettings updatedSeoSettings = seoSettingsService.updateSeoSettings(seoSettings);
            return ResponseEntity.ok(updatedSeoSettings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
