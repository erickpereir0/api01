package api01.demo.controller;

import api01.demo.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api01.demo.service.Usersservices;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("users")
public class UsersController {

    private Usersservices usersservice;

    public UsersController(Usersservices usersservice) {
        this.usersservice = usersservice;
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody CreateUsersDto createUsersDto)  {
        var userId = usersservice.createUsers(createUsersDto);

        return (ResponseEntity<Users>) ResponseEntity.created(URI.create("users"));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        var users = usersservice.getAllUsers();

        return (ResponseEntity<List<Users>>) ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id)  {
        var users = usersservice.getUserById(id);

        return (ResponseEntity<Users>) ResponseEntity.ok(users);
    }

    @PutMapping
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUsersDto updateUsersDto) {
        usersservice.updateUserById(id, updateUsersDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable("id") Long id)  {
        usersservice.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }

}
