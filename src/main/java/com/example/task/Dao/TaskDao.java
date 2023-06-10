package com.example.task.Dao;

import com.example.task.Entity.ListData;
import com.example.task.Entity.TaskData;
import com.example.task.From.*;

import java.util.List;

public interface TaskDao {
    int signUpDataInsert(SignUpForm signUpForm);
    int taskFormInsert(TaskForm taskForm);
    int listFormInsert(ListForm listForm);
    int initTaskFormInsert(InitTaskForm initTaskForm);
    int taskUpdate(TaskForm taskForm,int id);
    int taskListIdUpdate(TaskListIdUpdateForm taskListIdUpdateForm);
    List<ListData> getListData();
    List<TaskData> getTaskData();
    TaskData findById(int id);
}
