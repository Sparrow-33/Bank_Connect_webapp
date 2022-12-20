package com.simplon.bank_connect.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSenderService {

    private static final String ACCOUNT_SID = "AC2ce9c724c59355056772acb84b96623d";

    private static final String ACCOUNT_TOKEN = "63aa3326f071ce9b41835d3ba15863de";

    public Boolean sendSms(String to, String body) {
        System.out.println("Sending sms to " + to + " with body " + body);
        System.out.println("ACCOUNT_SID " + ACCOUNT_SID);
        // Set up account SID and auth token
        Twilio.init(ACCOUNT_SID, ACCOUNT_TOKEN);
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber("+18656720824"), body).create();
        return message.getErrorMessage() == null;
    }

}
