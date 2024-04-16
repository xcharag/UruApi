package com.uruapi.uruapi.controller;

import com.uruapi.uruapi.DTO.ClientDTO;
import com.uruapi.uruapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.addClient(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(clientService.updateClient(clientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/del{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        List<ClientDTO> clientDtos = clientService.getAllClients();
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }
}
