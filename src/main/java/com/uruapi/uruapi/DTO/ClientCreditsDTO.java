package com.uruapi.uruapi.DTO;

import lombok.Data;

@Data
public class ClientCreditsDTO {
    private Long id;
    private Long idClient;
    private Float credits;
    private String currency;
    private String description;
}
