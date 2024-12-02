package br.com.rodrigo.mdm.person.controller;

import br.com.rodrigo.mdm.person.dto.*;
import br.com.rodrigo.mdm.person.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonDTO> idToPerson(@PathVariable Long id) {
        PersonDTO person = personService.convertToObject(id);
        return Optional.ofNullable(person)
                .map(pp -> ResponseEntity.ok().body(pp))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa")
    public ResponseEntity<Long> personToId(@RequestParam Long identity, @RequestParam Integer personType) {
        Long personId = personService.convertToId(identity, personType);
        return Optional.ofNullable(personId)
                .map(id -> ResponseEntity.ok().body(id))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
