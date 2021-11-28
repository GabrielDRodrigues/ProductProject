package mentoring.productProject.controller;


import mentoring.productProject.controller.TokenService;
import mentoring.productProject.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    public AuthenticationController() {
    }

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dataBaseLogin = form.trasnform();

        try {
            Authentication authentication = authManager.authenticate(dataBaseLogin);
            String token = tokenService.generateToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();

        }

    }
}
