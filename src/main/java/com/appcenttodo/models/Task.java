package com.appcenttodo.models;


import com.appcenttodo.enums.TaskStatus;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TBL_TASKS")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Id
    //@SequenceGenerator(name= "TASK_SEQUENCE", sequenceName = "TASK_SEQUENCE_ID", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @NotNull
    @Column(name = "task_title")
    private String taskTitle;
    @NotNull
    private TaskStatus status;
    @Column(name = "createdDate")
    private Date createdDate;


}
