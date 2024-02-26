package com.atlas.menter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "chore_assignment")
@Getter
@Setter
public class ChoreAssignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "assigned_user")
    private User assignedUser;

    @Column(name = "current_chore")
    private Chore currentChore;

    @Column(name = "recurring")
    private boolean recurring;
}
