package org.sofka.services;

import io.smallrye.mutiny.Uni;
import org.sofka.dto.ValidadorDto;
import org.sofka.entity.ValidadorEntity;
import org.sofka.repository.ValidadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ValidadorServices {

    @Inject
    ValidadorRepository validadorRepository;

    public Uni<ValidadorEntity> createValidador(ValidadorDto validadorDto){
        ValidadorEntity validadorEntity = new ValidadorEntity(validadorDto.getTipoDocumento(),
                validadorDto.getExpresionRegular());
        //todo meter en un try cath
        return validadorRepository.persist(validadorEntity);
    }

    public Uni<ValidadorEntity> findByName(String tipoDocumento){
        return validadorRepository.find("tipoDocumento", tipoDocumento).firstResult();
    }

    public Uni<Long> deleteValidador(String tipoDocumento){
        return validadorRepository.delete("tipoDocumento", tipoDocumento);
    }

    public Uni<List<ValidadorEntity>> getAll(){
        return validadorRepository.findAll().list();
    }


}
