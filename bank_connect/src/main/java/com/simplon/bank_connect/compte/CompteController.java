package com.simplon.bank_connect.compte;

import com.simplon.bank_connect.compte.standard.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {


    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PostMapping("/add/standard")
    public Standard saveStandard(@RequestBody Standard standard, @RequestParam Long idClient) {
        System.out.println(standard);
        return (Standard) compteService.saveCompte(standard, idClient);
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
