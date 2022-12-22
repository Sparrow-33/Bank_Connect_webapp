package com.simplon.bank_connect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
 @NoArgsConstructor
    public class AuthenticationRequest {
        private String email;
        private String password;
    }


