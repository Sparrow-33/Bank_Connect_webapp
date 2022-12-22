package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    //get client by id
    @GetMapping("/find/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        return clientService.getClientById(id);
    }
//get client by cin
    @GetMapping("/find")
    public Client getClientByCin(@RequestParam("cin") String cin) {
        System.out.println("cin = " + cin);
        return clientService.getClientByCin(cin);
    }

    @PostMapping("/add")
    public Client saveClient(@RequestBody Client client) {
        System.out.println(client);
        return clientService.saveClient(client);

    }
}
