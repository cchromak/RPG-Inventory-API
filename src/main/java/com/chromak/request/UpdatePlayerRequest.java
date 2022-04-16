package com.chromak.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdatePlayerRequest {

    @NotNull(message = "Player Id is required.")
    private Long id;

    private String firstName;

    private String lastName;

    private String homePlanet;

    private String quote;

}
