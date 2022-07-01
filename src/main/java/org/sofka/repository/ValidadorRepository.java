package org.sofka.repository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import org.sofka.entity.ValidadorEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidadorRepository implements ReactivePanacheMongoRepository<ValidadorEntity> {
}
