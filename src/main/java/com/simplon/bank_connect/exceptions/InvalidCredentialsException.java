package com.simplon.bank_connect.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.security.core.AuthenticationException;


public class InvalidCredentialsException extends AuthenticationException {

      private String message;
      public InvalidCredentialsException(String message) {
        super(message);
        this.message = message;
    }
}
