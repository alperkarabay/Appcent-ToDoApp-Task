package com.appcenttodo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TBL_USERS")
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String username;
    private String password;


}
