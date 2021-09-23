package com.example.demo.training;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Task {

    private String title;
    private Integer priority;
    private Date date;
    private boolean effective;


    public List<Task> makeTasks() {
        List<Task> taskList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            Task task = new Task();
            task.setTitle("a" + i);
            task.setPriority(i);
            task.setDate(new Date());
            if (i % 2 == 0) {
                task.setEffective(true);
            } else {
                task.setEffective(false);
            }
            taskList.add(task);
        }
        System.out.println(taskList);
        return taskList;
    }

    public List<Task> effective() {
        List<Task> taskList = makeTasks();
        taskList
                .stream()
                .filter(Task::isEffective)
                .findFirst()
                .map(Task::isEffective);

        return taskList;
    }
}
