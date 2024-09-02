package network.bobnet.quantumgrid.metaseo_service.service;

import lombok.RequiredArgsConstructor;
import network.bobnet.quantumgrid.metaseo_service.entity.SeoMetadata;
import network.bobnet.quantumgrid.metaseo_service.entity.SeoSettings;
import network.bobnet.quantumgrid.metaseo_service.enums.ChangeFrequency;
import network.bobnet.quantumgrid.metaseo_service.repository.SeoMetadataRepository;
import network.bobnet.quantumgrid.metaseo_service.repository.SeoSettingsRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SitemapService {

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String URLSET_OPEN_TAG = "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";
    private static final String URLSET_CLOSE_TAG = "</urlset>";

    private final SeoMetadataRepository seoMetadataRepository;
    private final SeoSettingsRepository seoSettingsRepository;

    public String generateSitemap() {
        List<SeoMetadata> seoMetadataList = seoMetadataRepository.findAll();

        StringBuilder sitemapBuilder = new StringBuilder();
        sitemapBuilder.append(XML_HEADER).append("\n").append(URLSET_OPEN_TAG).append("\n");

        String dateTimePattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateTimePattern);

        for (SeoMetadata seoMetadata : seoMetadataList) {
            Optional<SeoSettings> seoSettingsOpt = seoSettingsRepository.findByEntityType(seoMetadata.getEntityType());

            String changefreq = String.valueOf(seoSettingsOpt.map(SeoSettings::getChangefreq).orElse(ChangeFrequency.WEEKLY));
            String priority = seoSettingsOpt.map(SeoSettings::getPriority).orElse("0.5");

            sitemapBuilder.append("<url>").append("\n")
                    .append("<loc>").append(seoMetadata.getCanonicalUrl()).append("</loc>").append("\n")
                    .append("<lastmod>").append(seoMetadata.getUpdatedAt().format(dateFormatter)).append("</lastmod>").append("\n")
                    .append("<changefreq>").append(changefreq).append("</changefreq>").append("\n")
                    .append("<priority>").append(priority).append("</priority>").append("\n")
                    .append("</url>").append("\n");
        }

        sitemapBuilder.append(URLSET_CLOSE_TAG);
        return sitemapBuilder.toString();
    }
}
