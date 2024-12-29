package matecom.matecom.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import matecom.matecom.Entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
}
