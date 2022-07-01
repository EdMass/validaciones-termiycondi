package org.sofka.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidadorDto {
    private String tipoDocumento;
    private String expresionRegular;
}
