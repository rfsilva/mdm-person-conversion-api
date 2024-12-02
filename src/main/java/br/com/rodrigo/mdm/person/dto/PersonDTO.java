package br.com.rodrigo.mdm.person.dto;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long identity;
    private Type type;
    private String name;
    private LocalDate birthDate;
    private String telephone;
    private String email;
    private String address;
    private Genre genre;
    private Status status;

}
