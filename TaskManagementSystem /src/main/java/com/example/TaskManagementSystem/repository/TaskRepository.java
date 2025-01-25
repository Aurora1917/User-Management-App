package com.example.TaskManagementSystem.repository;

import com.example.TaskManagementSystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findTaskByUser_Id(Long user_id);
    List<Task> findTaskByStatus(String status);
    List<Task> findTaskByUser_IdAndStatus(Long userId, String status);

    @Modifying
    @Query("UPDATE Task t SET t.status = :status WHERE t.id = :taskId")
    void updateTaskStatus(@Param("taskId") long taskId, @Param("status") String status);
}
