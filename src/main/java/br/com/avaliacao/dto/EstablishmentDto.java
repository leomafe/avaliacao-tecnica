package br.com.avaliacao.dto;

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
public class EstablishmentDto  {


    private String id;

    private String name;

    private GeolocationDto geolocation;
}
