package com.example.demo.training;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Agenda {

    private List<Task> tasks = new ArrayList<>();

    private List<Task> getEffectiveTask() {
        return tasks.stream().filter(Task::isEffective).collect(Collectors.toList());
    }

    private List<Task> getTaskByDate(Date date) {
        return tasks.stream().filter(task -> task.getDate().equals(date)).collect(Collectors.toList());
    }

}
