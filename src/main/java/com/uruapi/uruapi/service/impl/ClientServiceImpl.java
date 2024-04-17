package com.uruapi.uruapi.service.impl;

import com.uruapi.uruapi.DTO.ClientDTO;
import com.uruapi.uruapi.entity.Client;
import com.uruapi.uruapi.exception.ResourceNotFoundException;
import com.uruapi.uruapi.repository.ClientRepository;
import com.uruapi.uruapi.service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = mapToEntity(clientDTO);
        Client newClient = clientRepository.save(client);
        return mapToDto(newClient);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client ExistingClient = clientRepository.findById(clientDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientDTO.getId().toString()));
        ExistingClient.setName(clientDTO.getName());
        ExistingClient.setLastName(clientDTO.getLastName());
        ExistingClient.setGender(clientDTO.getGender());
        ExistingClient.setEmail(clientDTO.getEmail());

        clientRepository.save(ExistingClient);
        return mapToDto(ExistingClient);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client", "id", id.toString());
        }
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client", "id", id.toString()));
        return mapToDto(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::mapToDto).toList();
    }

    private ClientDTO mapToDto(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getIdClient());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setGender(client.getGender());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }

    private Client mapToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setGender(clientDTO.getGender());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
}
