package api01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api01.demo.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
