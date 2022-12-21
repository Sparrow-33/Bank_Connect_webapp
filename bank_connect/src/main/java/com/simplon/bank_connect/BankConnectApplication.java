package com.simplon.bank_connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BankConnectApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BankConnectApplication.class, args);

//		CompteRepository professionelRepository = configurableApplicationContext.getBean(ProfessionelRepository.class);
//
//		CompteRepository standardRepository = configurableApplicationContext.getBean(StandardRepository.class);
//
//		ClientService clientService = configurableApplicationContext.getBean(ClientService.class);
//
//		CompteService compteService = configurableApplicationContext.getBean(CompteService.class);
//
//		Client client = clientService.getClientById(1L);
//
//		Compte compte = compteService.getCompteByNumeroCompte("1234567890");
//
//		System.out.println(compte);








	}

}
