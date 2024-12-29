package matecom.matecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matecom.matecom.Entity.Tasks;
import matecom.matecom.Service.Tasks.TasksService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TasksService taskService;

    @PostMapping
    public ResponseEntity<Tasks> addTask(@RequestBody Tasks task) {
        Tasks createdTask = taskService.addTask(task);
        return ResponseEntity.ok(createdTask);
    }
    

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Tasks>> getTasksByUser(@PathVariable int userId) {
        List<Tasks> tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable int taskId) {
        taskService.deleteTask(taskId);
    }
}
