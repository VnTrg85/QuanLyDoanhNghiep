package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import matecom.matecom.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
