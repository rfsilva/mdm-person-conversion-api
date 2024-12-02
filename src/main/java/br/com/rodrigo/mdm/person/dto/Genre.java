package br.com.rodrigo.mdm.person.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Genre {

    MALE(1), FEMALE(2);

    @JsonValue
    private int value;

    public static Genre of(int value) {
        return Arrays.stream(Genre.values())
                .filter(tc -> value == tc.getValue())
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
