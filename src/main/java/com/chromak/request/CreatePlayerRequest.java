package com.chromak.request;

import com.chromak.entity.Item;
import com.chromak.entity.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;


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

    private Set<CreateItemRequest> items;

    private Set<CreateStatsRequest> stats;

}
