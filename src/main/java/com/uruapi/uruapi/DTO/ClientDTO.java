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
}
