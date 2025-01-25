package com.example.TaskManagementSystem.controller;



import com.example.TaskManagementSystem.model.Task;
import com.example.TaskManagementSystem.service.TaskService;
import com.example.TaskManagementSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService,UserService userService)
    {
        this.taskService=taskService;
        this.userService = userService;

    }

    // Tasklar Sayfası
    @GetMapping
    public String getTasks(Model model,
                           @RequestParam(required = false) Long user_id,
                           @RequestParam(required = false) String status) {
        List<Task> tasks;

        // Dinamik Filtreleme
        if (user_id != null && status != null) {
            tasks = taskService.getTasksByUserAndStatus(user_id, status);
        } else if (user_id != null) {
            tasks = taskService.getTasksByUser_Id(user_id);
        } else if (status != null) {
            tasks = taskService.getTasksByStatus(status);
        } else {
            tasks = taskService.getTasks();
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("users", userService.getUsers()); // Kullanıcıları da ekle
        return "task-management"; // Thymeleaf template ismi
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task, @RequestParam Long user_id) {
        taskService.addTask(task, user_id);
        return "redirect:/tasks";
    }


    @PostMapping("/update-status")
    public String updateTaskStatus(@RequestParam("taskId") long taskId, @RequestParam("status") String status) {
        taskService.updateTaskStatus(taskId, status);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{task_id}")
    public String deleteTask(@PathVariable long task_id) {
        taskService.deleteTask(task_id);
        return "redirect:/tasks";
    }


}
