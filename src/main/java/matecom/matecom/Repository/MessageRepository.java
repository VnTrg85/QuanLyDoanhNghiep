package matecom.matecom.Repository;

import matecom.matecom.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByGroupchats_Id(int groupchatId);
}
