package com.simplon.bank_connect;

import com.simplon.bank_connect.compte.Compte;
import com.simplon.bank_connect.compte.CompteRepository;
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

		Compte comptePro = new Professionel("1234567890", 1000.0, "1234", CompteType.COMPTE_PROFESSIONNEL, 10000.0, 200000.0, LocalDate.now(), LocalDate.now().plusYears(10), LocalDate.now());

		Compte compteStandard = new Standard("0987654321", 1000.0, "1234", CompteType.COMPTE_STANDARD, 10000.0, 200000.0, LocalDate.now(), LocalDate.now().plusYears(10), LocalDate.now());

		professionelRepository.save(comptePro);

		standardRepository.save(compteStandard);

	}

}
