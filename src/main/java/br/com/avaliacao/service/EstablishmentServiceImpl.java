package br.com.avaliacao.service;

import br.com.avaliacao.dto.EstablishmentDto;
import br.com.avaliacao.dto.GeolocationDto;
import br.com.avaliacao.exception.EstablishmentNotFoundException;
import br.com.avaliacao.model.EstablishmentModel;
import br.com.avaliacao.model.GeoLocationModel;
import br.com.avaliacao.repository.EstablishmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Objects;

@ApplicationScoped
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentRepository repository;

    @Override
    public void insert(EstablishmentDto dto) {

        var model = buildNewEstablishment(dto);
        repository.persist(model);


    }

    @Override
    public void update(String id, EstablishmentDto dto) {

        var model = repository.findById(new ObjectId(id));

        model.setName(dto.getName());
        model.getGeoLocation().setLatitude(dto.getGeolocation().getLatitude());
        model.getGeoLocation().setLongitude(dto.getGeolocation().getLongitude());

        repository.update(model);
    }

    @Override
    public void delete(String id) {

        repository.deleteById(new ObjectId(id));

    }

    @Override
    public EstablishmentDto findEstablishment(long latitude, long longitude) {

        var model = repository
                .find("geolocation.latitude = ?1 and geolocation.longitude = ?2", latitude, longitude)
                .firstResult();

        if (Objects.isNull(model)) throw new EstablishmentNotFoundException();

        var geolocation = model.getGeoLocation();

        return EstablishmentDto
                .builder()
                .id(model.id.toString())
                .name(model.getName())
                .geolocation(GeolocationDto.builder().latitude(geolocation.getLatitude()).longitude(geolocation.getLongitude()).build())
                .build();
    }

    private EstablishmentModel buildNewEstablishment(EstablishmentDto dto) {

        var geolocationDto = dto.getGeolocation();
        return EstablishmentModel.builder()
                .name(dto.getName())
                .geoLocation(GeoLocationModel.builder()
                        .latitude(geolocationDto.getLatitude())
                        .longitude(geolocationDto.getLongitude())
                        .build()
                ).build();
    }
}
