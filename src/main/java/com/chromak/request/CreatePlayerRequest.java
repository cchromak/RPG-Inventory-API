package com.chromak.request;

import com.chromak.entity.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class CreatePlayerRequest {

    @NotBlank(message = "Firstname is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Home planet is required")
    private String homePlanet;

    @NotBlank(message = "Quote is required")
    private String quote;

}
