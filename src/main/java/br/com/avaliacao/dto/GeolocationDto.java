package br.com.avaliacao.dto;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode(callSuper = false)
@Builder
@Getter
@Setter
@AllArgsConstructor
@Jacksonized
public class GeolocationDto extends PanacheMongoEntity {

    private long latitude;
    private long longitude;

}
