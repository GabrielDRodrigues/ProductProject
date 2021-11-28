package mentoring.productProject.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

    private String name;
    private String email;

    public LoginForm(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public UsernamePasswordAuthenticationToken trasnform() {
        return new UsernamePasswordAuthenticationToken(name, email);
    }
}
