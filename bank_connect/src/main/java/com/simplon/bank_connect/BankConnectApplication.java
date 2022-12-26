package com.simplon.bank_connect;


import com.simplon.bank_connect.utils.SmsSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BankConnectApplication {
	public static void main(String[] args) {
				SpringApplication.run(BankConnectApplication.class, args);
	}

}
