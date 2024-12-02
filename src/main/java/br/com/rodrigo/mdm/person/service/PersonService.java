package br.com.rodrigo.mdm.person.service;

import br.com.rodrigo.mdm.person.dto.*;

public interface PersonService {
    public Long convertToId(Long identity, Integer type);

    public PersonDTO convertToObject(Long id);
}
