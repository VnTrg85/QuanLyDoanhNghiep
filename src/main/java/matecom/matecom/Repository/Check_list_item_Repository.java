package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import matecom.matecom.Entity.Check_list_item;


@Repository
public interface Check_list_item_Repository extends JpaRepository<Check_list_item, Integer> {
}
