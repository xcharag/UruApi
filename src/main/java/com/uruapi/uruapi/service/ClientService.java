package com.uruapi.uruapi.service;

import com.uruapi.uruapi.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO addClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    ClientDTO getClient(Long id);
    List<ClientDTO> getAllClients();
}
