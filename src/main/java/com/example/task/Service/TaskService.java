package com.example.task.Service;

import com.example.task.Entity.ListData;
import com.example.task.Entity.TaskData;
import com.example.task.From.*;

import java.util.List;

public interface TaskService {
    int signUpDataInsert(SignUpForm signUpForm);
    int taskFormInsert(TaskForm taskForm);
    int initTaskFormInsert(InitTaskForm initTaskForm);

    int listFormInsert(ListForm listForm);

    int taskListIdUpdate(TaskListIdUpdateForm taskListIdUpdateForm);

    int taskUpdate(TaskForm taskForm,int id);

    List<ListData> getListData();

    List<TaskData> getTaskData();

    TaskData findById(int id);
}
