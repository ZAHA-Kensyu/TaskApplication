package com.example.task.Service;

import com.example.task.Dao.TaskApplicationDao;
import com.example.task.Entity.ListData;
import com.example.task.Entity.TaskData;
import com.example.task.From.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskApplicationService implements TaskService {
    @Autowired
    TaskApplicationDao taskApplicationDao;

    @Override
    public int signUpDataInsert(SignUpForm signUpForm){
        return taskApplicationDao.signUpDataInsert(signUpForm);
    }
    public int taskFormInsert(TaskForm taskForm){return taskApplicationDao.taskFormInsert(taskForm);}

    public int initTaskFormInsert(InitTaskForm initTaskForm){return taskApplicationDao.initTaskFormInsert(initTaskForm);}
    public int listFormInsert(ListForm listForm){return taskApplicationDao.listFormInsert(listForm);}

    public int taskListIdUpdate(TaskListIdUpdateForm taskListIdUpdateForm){return taskApplicationDao.taskListIdUpdate(taskListIdUpdateForm);}

    public int taskUpdate(TaskForm taskForm,int id){return taskApplicationDao.taskUpdate(taskForm,id);}
    public List<ListData> getListData(){return taskApplicationDao.getListData();}

    public List<TaskData> getTaskData(){return taskApplicationDao.getTaskData();}

    public TaskData findById(int id){return taskApplicationDao.findById(id);}
}
