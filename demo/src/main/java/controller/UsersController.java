package controller;

import model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Usersservices;

import java.net.URI;


@RestController
@RequestMapping("users")
public class UsersController {

    private Usersservices usersservice;

    public UsersController(Usersservices usersservice) {
        this.usersservice = usersservice;
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody CreateUsersDto createUsersDto) throws Exception {
        var userId = usersservice.createUsers(createUsersDto);

        return (ResponseEntity<Users>) ResponseEntity.created(URI.create("users"));
    }

    @GetMapping
    public ResponseEntity<Users> getUsers() {
    }
}
