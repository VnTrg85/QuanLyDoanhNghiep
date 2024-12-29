package matecom.matecom.Service.Tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matecom.matecom.Entity.Tasks;
import matecom.matecom.Repository.TasksRepository;

@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    private TasksRepository taskRepository;

    @Override
    public Tasks addTask(Tasks task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Tasks> getTasksByUserId(int userId) {
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getUser().getId() == userId)
                .toList();
    }

    @Override
    public void deleteTask(int taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        } else {
            throw new IllegalArgumentException("Task ID không tồn tại.");
        }
    }
}
