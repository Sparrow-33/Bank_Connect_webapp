package com.simplon.bank_connect;

import com.simplon.bank_connect.client.Client;
import com.simplon.bank_connect.client.ClientRepository;
import com.simplon.bank_connect.client.ClientService;
import com.simplon.bank_connect.compte.Compte;
import com.simplon.bank_connect.compte.CompteRepository;
import com.simplon.bank_connect.compte.CompteService;
import com.simplon.bank_connect.compte.CompteType;
import com.simplon.bank_connect.compte.professionnel.Professionel;
import com.simplon.bank_connect.compte.professionnel.ProfessionelRepository;
import com.simplon.bank_connect.compte.standard.Standard;
import com.simplon.bank_connect.compte.standard.StandardRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class BankConnectApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BankConnectApplication.class, args);

		CompteRepository professionelRepository = configurableApplicationContext.getBean(ProfessionelRepository.class);

		CompteRepository standardRepository = configurableApplicationContext.getBean(StandardRepository.class);

		ClientService clientService = configurableApplicationContext.getBean(ClientService.class);

		CompteService compteService = configurableApplicationContext.getBean(CompteService.class);

		Client client = clientService.getClientById(1L);

		Compte compte = compteService.getCompteByNumeroCompte("1234567890");

		System.out.println(compte);








	}

}
