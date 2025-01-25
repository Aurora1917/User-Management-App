package com.example.TaskManagementSystem.service;


import com.example.TaskManagementSystem.model.Task;
import com.example.TaskManagementSystem.model.User;
import com.example.TaskManagementSystem.repository.TaskRepository;
import com.example.TaskManagementSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository)
    {
        this.taskRepository=taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public Task addTask(Task task, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        task.setUser(user); // Kullanıcıyı göreve ata
        return taskRepository.save(task);
    }


    public void deleteTask(long task_id)
    {
        taskRepository.deleteById(task_id);
    }

    public List<Task> getTasksByUser_Id(long user_id)
    {
        return taskRepository.findTaskByUser_Id(user_id);
    }

    public List<Task> getTasksByStatus(String status)
    {
       return taskRepository.findTaskByStatus(status);
    }


    public List<Task> getTasksByUserAndStatus(Long userId, String status) {
        return taskRepository.findTaskByUser_IdAndStatus(userId, status);
    }


    @Transactional
    public void updateTaskStatus(long taskId, String status) {
        taskRepository.updateTaskStatus(taskId, status);
    }

}
