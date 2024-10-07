package br.com.avaliacao.service;

import br.com.avaliacao.dto.EstablishmentDto;

public interface EstablishmentService {

    void insert(EstablishmentDto dto);

    void update(String id, EstablishmentDto dto);

    void delete(String id);

    EstablishmentDto findEstablishment(long latitude, long longitude);
}
