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
import com.simplon.bank_connect.utils.EmailSenderService;
import com.simplon.bank_connect.utils.SmsSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class BankConnectApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BankConnectApplication.class, args);

		SmsSenderService smsSenderService = configurableApplicationContext.getBean(SmsSenderService.class);

		smsSenderService.sendSms("+212606422895", "Hello baby girl !");








	}

}
