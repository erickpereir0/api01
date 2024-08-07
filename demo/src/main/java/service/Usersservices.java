package service;

import controller.CreateUsersDto;
import controller.UpdateUsersDto;
import model.Users;
import org.springframework.stereotype.Service;
import repository.UsersRepository;

import java.util.List;

@Service
public class Usersservices {

    private UsersRepository usersRepository;

    public Usersservices(UsersRepository usersRepository) {}

    public Long createUsers(CreateUsersDto createUsersDto) {
        var entity = new Users(
                createUsersDto.username(),
                createUsersDto.email(),
                createUsersDto.password()
        );

        var userSaved = usersRepository.save(entity);
        return userSaved.getId();
    }

    public List<Users> getAllUsers() {

        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {

        return usersRepository.findById(id).get();
    }

    public Users updateUserById(Long id, UpdateUsersDto updateUsersDto ) {

        var userEntity = usersRepository.findById(id);

        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUsersDto.username() != null) {
             user.setUsername(updateUsersDto.username());
            }

            if (updateUsersDto.password() != null) {
                user.setPassword(updateUsersDto.password());
            }
        }
        return getUserById(id);
    }

    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }
}
