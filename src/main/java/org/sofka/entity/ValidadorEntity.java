package org.sofka.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection = "validatetyc")
public class ValidadorEntity {

    private String tipoDocumento;
    private String expresionRegular;

}
