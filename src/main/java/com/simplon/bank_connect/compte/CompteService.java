package com.simplon.bank_connect.compte;

import com.simplon.bank_connect.client.ClientRepository;
import com.simplon.bank_connect.compte.professionnel.Professionel;
import com.simplon.bank_connect.compte.professionnel.ProfessionelRepository;
import com.simplon.bank_connect.compte.standard.Standard;
import com.simplon.bank_connect.compte.standard.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    private final StandardRepository standardRepository;
    private final ProfessionelRepository professionelRepository;

    private final ClientRepository clientRepository;

    @Autowired
    public CompteService(StandardRepository standardRepository, ProfessionelRepository professionelRepository, ClientRepository clientRepository) {
        this.standardRepository = standardRepository;
        this.professionelRepository = professionelRepository;
        this.clientRepository = clientRepository;
    }

    public Compte saveCompte(Compte compte, Long idClient) {
        if(compte instanceof Standard){
            // set values for standard
            compte.setClient(clientRepository.findById(idClient).get());
            //set new numero compte
            String newNumeroCompte =   compte.getClient().getName().substring(0, 1).toUpperCase() + (int) (Math.random() * 1000000);
            compte.setNumeroCompte(newNumeroCompte);
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

    public boolean checkStatus(Compte compte){
        return compte.getStatus().equals("active");
    }


    // get all comptes by type
    public List<Compte> getAllComptesByType(String type){
        if(type.equals("COMPTE_STANDARD")){
            return standardRepository.findAll();
        }else if(type.equals("COMPTE_PROFESSIONNEL")){
            return professionelRepository.findAll();
        }
        return null;
    }


    public List<Compte> getAllComptes() {
        List<Compte> comptes = standardRepository.findAll();
        comptes.addAll(professionelRepository.findAll());
        return comptes;
    }

    public List<Compte> getAllCompteProfessionel() {
        return professionelRepository.findAll();
    }

    public List<Compte> getAllCompteStandard() {
        return standardRepository.findAll();
    }
}
