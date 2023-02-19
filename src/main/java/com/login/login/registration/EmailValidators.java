package com.login.login.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidators implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }
}
