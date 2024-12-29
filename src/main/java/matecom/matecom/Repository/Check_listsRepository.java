package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import matecom.matecom.Entity.Check_lists;

@Repository
public interface Check_listsRepository extends JpaRepository<Check_lists,Integer> {
    
}
