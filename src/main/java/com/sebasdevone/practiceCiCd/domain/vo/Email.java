package com.sebasdevone.practiceCiCd.domain.vo;

import com.sebasdevone.practiceCiCd.domain.exception.EmailInvalidException;

import java.util.regex.Pattern;

public record Email (String email){
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    public Email{
        if(email == null||email.isBlank())
            throw new EmailInvalidException("El email no puede ser nulo o vacio");
        String emailTrim = email.trim();
        if(!EMAIL_PATTERN.matcher(emailTrim).matches())
            throw new EmailInvalidException("El email no es valido: "+email);
        email = emailTrim.toLowerCase();
    }
}
