package network.bobnet.quantumgrid.metaseo_service.enums;

import lombok.Getter;

@Getter
public enum ChangeFrequency {
    ALWAYS("always"),
    HOURLY("hourly"),
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly"),
    NEVER("never");

    private final String value;

    ChangeFrequency(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
