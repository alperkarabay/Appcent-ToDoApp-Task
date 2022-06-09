package com.appcenttodo.models;

import com.appcenttodo.enums.TaskStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TBL_USERS")
public class User {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
