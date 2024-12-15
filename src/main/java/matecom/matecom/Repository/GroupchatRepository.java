package matecom.matecom.Repository;

import matecom.matecom.Entity.Groupchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupchatRepository extends JpaRepository<Groupchats,Integer>{
}
