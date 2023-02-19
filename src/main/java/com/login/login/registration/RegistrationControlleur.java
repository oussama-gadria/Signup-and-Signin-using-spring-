package com.login.login.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
public class RegistrationControlleur {
    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) throws MessagingException {
        return registrationService.register(request);
    }
    @GetMapping(path = "Confirm")
    public void confirm(@RequestParam("token") String token){
       registrationService.confirme(token);
    }
}
