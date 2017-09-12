package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Client;
import org.itstep.j2_16.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/clients")


public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getClient() {
        return new ResponseEntity<>(clientService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIdClient(@PathVariable long id){
        return new ResponseEntity<>(clientService.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable long id, @RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(id, client), OK);
    }
}
