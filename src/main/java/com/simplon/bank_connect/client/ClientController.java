package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String hello() {
        return "Hello Oussama";
    }


    @PostMapping("/add")
    public Client saveClient(@RequestBody Client client) {
        System.out.println(client);
        return clientService.saveClient(client);
    }
}
