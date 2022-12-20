package com.simplon.bank_connect.compte;

import com.simplon.bank_connect.compte.professionnel.Professionel;
import com.simplon.bank_connect.compte.professionnel.ProfessionelRepository;
import com.simplon.bank_connect.compte.standard.Standard;
import com.simplon.bank_connect.compte.standard.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    private final StandardRepository standardRepository;
    private ProfessionelRepository professionelRepository;

    @Autowired
    public CompteService(StandardRepository standardRepository, ProfessionelRepository professionelRepository) {
        this.standardRepository = standardRepository;
        this.professionelRepository = professionelRepository;
    }

    public Compte saveCompte(Compte compte){
        if(compte instanceof Standard){
            return standardRepository.save((Standard) compte);
        }else if(compte instanceof Professionel){
            return professionelRepository.save((Professionel) compte);
        }
        return null;
    }

    public Compte getCompteStandardById(Long id){
        return standardRepository.findById(id).get();
    }

    public Compte getCompteProById(Long id){
        return professionelRepository.findById(id).get();
    }

    public Compte getCompteByNumeroCompte(String numeroCompte){
        Compte compte = standardRepository.findByNumeroCompte(numeroCompte);
        if(compte == null){
            compte = professionelRepository.findByNumeroCompte(numeroCompte);
        }
        return compte;
    }




}
