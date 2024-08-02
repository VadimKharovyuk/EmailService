package com.example.emailservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;


    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendRegistrationEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok("Email sent");
    }
    @PostMapping("/password")
    public ResponseEntity<String> sendEmailPassword(@RequestParam String emailRequest ,String pass) {
        emailService.sendPasswordReset(emailRequest,pass);
        return ResponseEntity.ok("New password sent to email");
    }
}
