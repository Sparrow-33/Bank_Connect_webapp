package com.simplon.bank_connect.client;


import com.simplon.bank_connect.utils.SmsSenderService;
//import com.twilio.twiml.voice.Sms;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final PasswordEncoder passwordEncoder;
    private final SmsSenderService smsSenderService;

    String[] code;


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
        return clientService.saveClient(client);
    }



    @PostMapping("/save/sendSms")
    public Client sendSms(@RequestBody Client client) {
        code = new String[]{clientService.generateCode()};
        client.setConfimationCode(code[0]);
        System.out.println(client.toString());
        assert client.getPhone() != null;
        clientService.saveClient(client);

        /* INVALID API TOKEN
        smsSenderService.sendSms(client.getPhone(), "Votre code confirmation est : " + code[0] + " .");
        */
        codeInvalidator();
        return client;
    }

    @GetMapping("/save/verifySms")
    public String verifySms(@RequestParam("code") String code,@RequestParam("id") Long id) {
        Client client = clientService.getClientById(id);
        assert  client != null;
        if (this.code[0].equals(code)) {
            return "Code correct";
        } else {
            return "Code incorrect";
        }
    }

    private void codeInvalidator( ) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {

                    @Override

                    public void run() {
                     code[0] = clientService.generateCode();
                    }

                },

                60000

        );
    }
}
