package matecom.matecom.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class List_cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name="task_id",nullable = false)
    private Tasks tasks;
}   
