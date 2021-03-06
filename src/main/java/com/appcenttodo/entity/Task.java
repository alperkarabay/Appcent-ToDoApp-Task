package com.appcenttodo.entity;


import com.appcenttodo.enums.TaskStatus;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "TBL_TASKS")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @NotNull
    @Column(name = "task_title")
    private String taskTitle;
    @NotNull
    private TaskStatus status;
    @NotNull
    private long userId;



}
