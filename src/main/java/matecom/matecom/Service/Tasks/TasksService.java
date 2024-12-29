package matecom.matecom.Service.Tasks;

import matecom.matecom.Entity.Tasks;
import java.util.List;

public interface TasksService {
    public Tasks addTask(Tasks task);
    public List<Tasks> getTasksByUserId(int userId);
    public void deleteTask(int taskId);
}
