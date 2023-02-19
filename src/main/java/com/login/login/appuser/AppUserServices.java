package com.login.login.appuser;

import com.login.login.Security.PasswordEncoder;
import com.login.login.registration.token.ConfirmationToken;
import com.login.login.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserServices implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG= "user with email %s not found ";
    @Autowired
    private final StudentRepository studentRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
    public String SignUpUser(AppUser appUser){
        boolean userExist= studentRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
        throw new IllegalStateException("email already taken");
        }
        String encodedpassword=passwordEncoder.bCryptPasswordEncoder().encode(appUser.getPassword());
        appUser.setPassword(encodedpassword);
        studentRepository.save(appUser);
       String  token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken =new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
}
