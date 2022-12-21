package com.simplon.bank_connect.compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {


    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
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
