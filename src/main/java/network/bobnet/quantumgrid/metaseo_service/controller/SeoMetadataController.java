package network.bobnet.quantumgrid.metaseo_service.controller;

import lombok.AllArgsConstructor;
import network.bobnet.quantumgrid.metaseo_service.entity.SeoMetadata;
import network.bobnet.quantumgrid.metaseo_service.service.SeoMetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/seo")
public class SeoMetadataController {

    private final SeoMetadataService seoMetadataService;

    @PostMapping
    public ResponseEntity<SeoMetadata> createSeoMetadata(@RequestBody SeoMetadata seoMetadata) {
        SeoMetadata createdSeoMetadata = seoMetadataService.createSeoMetadata(seoMetadata);
        return ResponseEntity.ok(createdSeoMetadata);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeoMetadata> getSeoMetadataById(@PathVariable Long id) {
        Optional<SeoMetadata> seoMetadata = seoMetadataService.getSeoMetadataById(id);
        return seoMetadata.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SeoMetadata>> getSeoMetadataByEntity(
            @RequestParam Long entityId,
            @RequestParam String entityType) {
        List<SeoMetadata> seoMetadataList = seoMetadataService.getSeoMetadataByEntity(entityId, entityType);
        return ResponseEntity.ok(seoMetadataList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeoMetadata> updateSeoMetadata(@PathVariable Long id, @RequestBody SeoMetadata seoMetadata) {
        seoMetadata.setId(id);
        SeoMetadata updatedSeoMetadata = seoMetadataService.updateSeoMetadata(seoMetadata);
        return ResponseEntity.ok(updatedSeoMetadata);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeoMetadata(@PathVariable Long id) {
        seoMetadataService.deleteSeoMetadata(id);
        return ResponseEntity.noContent().build();
    }
}
