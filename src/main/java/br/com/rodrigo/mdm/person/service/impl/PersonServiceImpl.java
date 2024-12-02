package br.com.rodrigo.mdm.person.service.impl;

import br.com.rodrigo.mdm.person.dto.*;
import br.com.rodrigo.mdm.person.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private RabbitMQService rabbitMQService;

    @Override
    public Long convertToId(Long identity, Integer type) {
        log.info("Obtendo ID do objeto através dos dados identity: {}, Tipo: {}", identity, type);
        Long personId = generatePersonId(identity, type);
        log.info("ID da pessoa obtido: {}", personId);
        rabbitMQService.send(String.valueOf(personId));
        return null;
    }

    @Override
    public PersonDTO convertToObject(Long id) {
        log.info("Obtendo dados do objeto através do ID {}", id);
        PersonDTO pessoa = generatePerson(id);
        log.info("Dados obtidos: {}", pessoa.toString());
        rabbitMQService.send(String.valueOf(id));
        return generatePerson(id);
    }

    private Long generatePersonId(Long cpfCnpj, Integer tipoPessoaInt) {
        Type tipoPessoa = Type.of(tipoPessoaInt);
        if (tipoPessoa == null) {
            return null;
        }
        if (cpfCnpj != null) {
            return cpfCnpj;
        }
        return null;
    }

    private PersonDTO generatePerson(Long id) {
        if (id == 0) {
            return null;
        }
        return PersonDTO.builder()
                .id(id)
                .genre(Genre.MALE)
                .identity(12345678909L)
                .name("Edson Arantes do Nascimento")
                .email("edson@pele.com.br")
                .birthDate(LocalDate.of(1940, 10, 10))
                .telephone("(11) 99854-5212")
                .status(Status.ACTIVE)
                .type(Type.INDIVIDUAL)
                .build();
    }
}
