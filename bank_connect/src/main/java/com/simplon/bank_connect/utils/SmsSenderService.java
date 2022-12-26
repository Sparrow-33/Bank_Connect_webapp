package com.simplon.bank_connect.utils;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class SmsSenderService {


    private String ACCOUNT_SID = "AC9f11708e058f46cf5d9443d16be455d7";

    private String AUTH_TOKEN = "002ec9b4aaa354d906ab9f3d6cddf167";


    private String PHONE_NUMBER = "+13866663914";


    public Boolean sendSms(String to, String body) {
        System.out.println("Sending sms to " + to + " with body " + body);
        System.out.println("ACCOUNT_SID " + ACCOUNT_SID);
        // Set up account SID and auth token
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new com.twilio.type.PhoneNumber(to), new PhoneNumber(PHONE_NUMBER), body).create();
        return message.getErrorMessage() == null;
    }

}
