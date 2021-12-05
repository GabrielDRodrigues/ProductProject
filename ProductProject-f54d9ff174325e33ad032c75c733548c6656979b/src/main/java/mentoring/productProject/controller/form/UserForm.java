package mentoring.productProject.controller.form;

import mentoring.productProject.repository.UserRepository;
import mentoring.productProject.resource.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {

    @NotEmpty @NotNull
    private String name;
    @NotEmpty @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User converter() {
        return new User(name, email);
    }

    public User update(Integer id, UserRepository userRepository) {
        User user = userRepository.getById(id);
        user.getName(this.name);
        user.getEmail(this.email);

        return user;
    }
}
