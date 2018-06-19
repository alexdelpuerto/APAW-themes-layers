package api.apiControllers;

import api.businessController.UserBusinessController;
import api.dtos.UserDto;
import api.exceptions.ArgumentNotValidException;

import java.util.Optional;

public class UserApiController {

    public static final String USERS = "/users";

    public static final String ID_ID = "/{id}";

    private UserBusinessController userBusinessController = new UserBusinessController();

    public String create(UserDto userDto) {
        this.validate(userDto, "userDto");
        this.validate(userDto.getNick(), "UserDto Nick");
        return this.userBusinessController.create(userDto);
    }

    public void update(String id, UserDto userDto) {
        this.validate(userDto, "userDto");
        this.validate(userDto.getNick(), "UserDto Nick");
        this.userBusinessController.update(id, userDto);
    }

    private void validate(Object property, String message) {
        Optional.ofNullable(property).orElseThrow(() -> new ArgumentNotValidException(message + " is NULL"));
    }
}
