package com.simplon.bank_connect.compte;

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

    @PostMapping("/add")
    public Compte saveCompte(@RequestBody Compte compte) {
        System.out.println(compte);
        return compteService.saveCompte(compte);
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



}
