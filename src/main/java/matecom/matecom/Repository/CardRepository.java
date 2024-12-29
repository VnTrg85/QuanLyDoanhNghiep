package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import matecom.matecom.Entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
