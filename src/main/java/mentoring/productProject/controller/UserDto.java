package mentoring.productProject.controller;

import mentoring.productProject.resource.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Integer id;
    private String name;
    private String email;


    public UserDto(User user) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static List<UserDto> converter(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
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
