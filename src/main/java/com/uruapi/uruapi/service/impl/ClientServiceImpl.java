package com.uruapi.uruapi.service.impl;

import com.uruapi.uruapi.DTO.ClientDTO;
import com.uruapi.uruapi.entity.Client;
import com.uruapi.uruapi.exception.ResourceNotFoundException;
import com.uruapi.uruapi.repository.ClientRepository;
import com.uruapi.uruapi.service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServiceImpl implements ClientService {
    @Value("${email.regex}")
    private static String EMAIL_REGEX;

    @Value("${sql.injection.pattern}")
    private static String SQL_INJECTION_PATTERN;

    private final ClientRepository clientRepository;
    //private final ClientPaymentMethodsRepository clientPaymentMethodsRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = mapToEntity(clientDTO);
        if (isInvalidClient(clientDTO)) {
            throw new IllegalArgumentException("Invalid client");
        }
        clientRepository.save(client);
        return mapToDto(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client ExistingClient = clientRepository.findById(clientDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientDTO.getId().toString()));
        if (clientDTO.getEmail() != null && isValidEmail(clientDTO.getEmail()) && isSQLInjection(clientDTO.getEmail())) {
            ExistingClient.setEmail(clientDTO.getEmail());
        } else if (clientDTO.getName() != null && !isSQLInjection(clientDTO.getName())){
            ExistingClient.setName(clientDTO.getName());
        } else if (clientDTO.getLastName() != null && !isSQLInjection(clientDTO.getLastName())) {
            ExistingClient.setLastName(clientDTO.getLastName());
        } else if (clientDTO.getGender() != null && !isSQLInjection(clientDTO.getGender())) {
            ExistingClient.setGender(clientDTO.getGender());
        }

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
        client.setIdClient(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setGender(clientDTO.getGender());
        client.setEmail(clientDTO.getEmail());
        return client;
    }

    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    private static boolean isSQLInjection(String input) {
        Pattern pattern = Pattern.compile(SQL_INJECTION_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private boolean isInvalidClient(ClientDTO clientDTO) {
            if (clientDTO.getEmail() == null || clientDTO.getName() == null || clientDTO.getLastName() == null || clientDTO.getGender() == null) {
                return true;
            } else if (isSQLInjection(clientDTO.getEmail()) || isSQLInjection(clientDTO.getName()) || isSQLInjection(clientDTO.getLastName()) || isSQLInjection(clientDTO.getGender())) {
                return true;
            } else return !isValidEmail(clientDTO.getEmail());
    }
}
