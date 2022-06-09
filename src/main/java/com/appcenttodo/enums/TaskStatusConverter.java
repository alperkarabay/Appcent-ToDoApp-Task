package com.appcenttodo.enums;

import com.appcenttodo.models.Task;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus,String> {


    @Override
    public String convertToDatabaseColumn(TaskStatus taskStatus) {
        if(taskStatus==null) return null;
        else return taskStatus.getStatus();
    }

    @Override
    public TaskStatus convertToEntityAttribute(String s) {
        if(s.equals("TD")) return TaskStatus.TO_DO;
        else if(s.equals("IP")) return TaskStatus.IN_PROGRESS;
        else return TaskStatus.DONE;
    }

}
