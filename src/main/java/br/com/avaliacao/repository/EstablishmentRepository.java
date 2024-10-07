package br.com.avaliacao.repository;

import br.com.avaliacao.model.EstablishmentModel;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstablishmentRepository implements PanacheMongoRepository<EstablishmentModel> {



}
