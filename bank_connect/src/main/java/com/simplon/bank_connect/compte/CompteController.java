package com.simplon.bank_connect.compte;

import com.simplon.bank_connect.compte.professionnel.Professionel;
import com.simplon.bank_connect.compte.standard.Standard;
import com.simplon.bank_connect.utils.SmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {


    private final CompteService compteService;

    private final SmsSenderService smsSenderService;

    @Autowired
    public CompteController(CompteService compteService, SmsSenderService smsSenderService) {
        this.compteService = compteService;
        this.smsSenderService = smsSenderService;
    }

    @GetMapping("/sms")
    public void sendSms() {
        smsSenderService.sendSms("+212 606 422895", "Salam alikoum lala asmae neqadem lik rassi smiti brahim o rah khedite nemratek men facebook la kan momkin net3arefo");
    }

    @PostMapping("/add/standard")
    public Standard saveStandard( @RequestParam Long idClient) {
        Compte compte = new Standard();
        return (Standard) compteService.saveCompte(compte, idClient);
    }

    @PostMapping("/add/professional")
    public Professionel saveProfessional(@RequestParam Long idClient) {
        Compte compte = new Professionel();
        return (Professionel) compteService.saveCompte(compte, idClient);
    }

    @GetMapping("/professionel/all")
    public List<Compte> getAllCompteProfessionel() {
        return compteService.getAllCompteProfessionel();
    }

    @GetMapping("/standard/find")
    public List<Compte> getAllCompteStandard() {
        return compteService.getAllCompteStandard();
    }


    @GetMapping("/all")
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    //get compte by type
    @GetMapping("/find")
    public List<Compte> getCompteByType(@RequestParam("type") String type) {
        System.out.println("type = " + type);
        return compteService.getAllComptesByType(type);
    }

    //get compte by numero
    @GetMapping("/find/{numero}")
    public Compte getCompteByNumero(@PathVariable("numero") String numero) {
        return compteService.getCompteByNumeroCompte(numero);
    }



}
