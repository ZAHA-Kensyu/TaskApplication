package com.example.task.From;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TaskForm {
    private String name;
    private LocalDate deadlineDate;
    private LocalTime deadlineTime;
    private String url;
    private Integer priorityId;
    private Integer reminderId;
    private String memo;


}
