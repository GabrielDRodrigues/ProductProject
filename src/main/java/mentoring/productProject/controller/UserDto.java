package mentoring.productProject.controller;

import mentoring.productProject.resource.User;
import org.springframework.data.domain.Page;

public class UserDto {

    private Integer id;
    private String name;
    private String email;


    public UserDto(User user) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static Page<UserDto> converter(Page<User> users) {
        return users.map(UserDto::new);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
