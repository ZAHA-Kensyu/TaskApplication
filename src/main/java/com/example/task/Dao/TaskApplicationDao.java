package com.example.task.Dao;

import com.example.task.Entity.ListData;
import com.example.task.Entity.TaskData;
import com.example.task.From.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskApplicationDao implements TaskDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int signUpDataInsert(SignUpForm signUpForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("userId", signUpForm.getUserId());
        param.addValue("password", signUpForm.getPassWord());
        param.addValue("permission",2);
        param.addValue("email", signUpForm.getEmail());
        return namedParameterJdbcTemplate.update("INSERT INTO users (user_id,password,permission,email) VALUES(:userId,:password,:permission,:email)",param);
    }

    public int taskFormInsert(TaskForm taskForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("taskName",taskForm.getName());
        param.addValue("deadlineData",taskForm.getDeadlineDate());
        param.addValue("deadlineTIme",taskForm.getDeadlineTime());
        param.addValue("url",taskForm.getUrl());
        param.addValue("priorityId",taskForm.getPriorityId());
        param.addValue("reminderId",taskForm.getReminderId());
        param.addValue("memo",taskForm.getMemo());
        return namedParameterJdbcTemplate.update("INSERT INTO task (name,deadline_date,deadline_time,url,priorities_id,reminder_id,memo) VALUES(:taskName,:deadlineData,:deadlineTIme,:url,:priorityId,:reminderId,:memo)",param);
    }

    public int initTaskFormInsert(InitTaskForm initTaskForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("taskName",initTaskForm.getName());
        param.addValue("deadlineData",null);
        param.addValue("deadlineTIme",null);
        param.addValue("url",null);
        param.addValue("priorityId",null);
        param.addValue("reminderId",null);
        param.addValue("listId",initTaskForm.getListId());
        param.addValue("memo",null);
        param.addValue("isAdd",initTaskForm.getIsAdd());
        return namedParameterJdbcTemplate.update("INSERT INTO task (name,deadline_date,deadline_time,url,priorities_id,reminder_id,list_id,memo,is_add) VALUES(:taskName,:deadlineData,:deadlineTIme,:url,:priorityId,:reminderId,:listId,:memo,:isAdd)",param);
    }
    public int listFormInsert(ListForm listForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name",listForm.getName());
        param.addValue("boardId",1);
        return namedParameterJdbcTemplate.update("INSERT INTO list (name,board_id) VALUES(:name,:boardId)",param);
    }

    public int taskListIdUpdate(TaskListIdUpdateForm taskListIdUpdateForm){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("listId",taskListIdUpdateForm.getListId());
        param.addValue("id",taskListIdUpdateForm.getId());
        return namedParameterJdbcTemplate.update("UPDATE task SET list_id = :listId WHERE id = :id",param);
    }

    public List<ListData> getListData(){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("boardId",1);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM list WHERE board_id = :boardId",
                param,
                new DataClassRowMapper<>(ListData.class));
    }

    public int taskUpdate(TaskForm taskForm,int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",id);
        param.addValue("name",taskForm.getName());
        param.addValue("deadlineData",taskForm.getDeadlineDate());
        param.addValue("deadlineTime",taskForm.getDeadlineTime());
        param.addValue("url",taskForm.getUrl());
        param.addValue("priorityId",taskForm.getPriorityId());
        param.addValue("reminderId",taskForm.getReminderId());
        param.addValue("memo",taskForm.getMemo());
        return namedParameterJdbcTemplate.update(
                "UPDATE task SET name = :name,deadline_date = :deadlineData,deadline_time = :deadlineTime,url = :url,priorities_id = :priorityId,reminder_id = :reminderId, memo = :memo WHERE id = :id",param);
    }

    public List<TaskData> getTaskData(){
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM task",
                new DataClassRowMapper<>(TaskData.class));
    }

    public TaskData findById(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",id);
        var list =  namedParameterJdbcTemplate.query(
                "SELECT * FROM task WHERE id = :id",
                param,
                new DataClassRowMapper<>(TaskData.class));
        return list.isEmpty() ? null : list.get(0);
    }

}
