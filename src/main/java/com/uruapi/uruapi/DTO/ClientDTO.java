package com.uruapi.uruapi.DTO;

import com.uruapi.uruapi.entity.ClientPaymentMethods;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String gender;
    private String email;

    private List<ClientCreditsDTO> clientCredits = new ArrayList<>();
    private List<ClientPhoneNumbersDTO> clientPhoneNumbers = new ArrayList<>();
    private List<ClientPaymenthMethodsDTO> clientAddresses = new ArrayList<>();
    private List<UserDTO> users = new ArrayList<>();
}
