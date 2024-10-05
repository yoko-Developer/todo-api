package com.example.todo_api.service.task;

import com.example.todo_api.repositoy.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskEntity find() {
        return taskRepository.select()
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new IllegalArgumentException("TODO")); //TODO
    }
}
