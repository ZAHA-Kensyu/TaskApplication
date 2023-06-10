package com.example.task.Controller;

import com.example.task.Entity.ListData;
import com.example.task.Entity.TaskData;
import com.example.task.From.InitTaskForm;
import com.example.task.From.ListForm;
import com.example.task.From.TaskListIdUpdateForm;
import com.example.task.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getTaskData")
    List<TaskData> getTaskData(){
        var taskData = taskService.getTaskData();
        return  taskData;
    }

    @PostMapping("/postInitTaskData")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void initInsertData(@ModelAttribute InitTaskForm initTaskForm){
        System.out.println("initPost");
        taskService.initTaskFormInsert(initTaskForm);
    }

    @PostMapping("/postListData")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insertData(@ModelAttribute ListForm listForm){
        System.out.println("post");
        taskService.listFormInsert(listForm);
    }

    @GetMapping("/getListData")
    List<ListData> getListData(){
        var listData = taskService.getListData();
        return listData;
    }

    @PutMapping("/taskListIdUpdate")
    public void taskListIdUpdate(@ModelAttribute TaskListIdUpdateForm taskListIdUpdateForm){
        System.out.println("PUT入っている");
        taskService.taskListIdUpdate(taskListIdUpdateForm);
    }

    @GetMapping("/getTask/{id}")
    public TaskData getTask(@PathVariable int id){
        System.out.println("id"+id);
        TaskData taskData = taskService.findById(id);
        return taskData;
    }
}
