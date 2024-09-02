package network.bobnet.quantumgrid.metaseo_service.enums;

import lombok.Getter;

@Getter
public enum EntityType {
    POST("post"),
    PAGE("page");

    private final String value;

    EntityType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
