package network.bobnet.quantumgrid.metaseo_service.controller;

import network.bobnet.quantumgrid.metaseo_service.service.SitemapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sitemap")
public class SitemapController {

    private final SitemapService sitemapService;

    @Autowired
    public SitemapController(SitemapService sitemapService) {
        this.sitemapService = sitemapService;
    }

    @GetMapping(produces = "application/xml")
    public ResponseEntity<String> getSitemap() {
        String sitemap = sitemapService.generateSitemap();
        return ResponseEntity.ok(sitemap);
    }
}
