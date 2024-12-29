package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import matecom.matecom.Entity.List_cards;

@Repository
public interface List_cardsRepository extends JpaRepository<List_cards,Integer> {
}
