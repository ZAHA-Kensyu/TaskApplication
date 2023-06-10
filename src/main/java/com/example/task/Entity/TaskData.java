package com.example.task.Entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TaskData {
    private Integer id;
    private String name;
    private LocalDate deadlineDate;
    private LocalTime deadlineTime;
    private String url;
    private Integer priorityId;
    private Integer reminderId;
    private Integer listId;
    private String memo;
    private Boolean isAdd;
}
