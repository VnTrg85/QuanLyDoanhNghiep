package matecom.matecom.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Check_lists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Boolean status;
    

    @ManyToOne
    @JoinColumn(name="card_id",nullable = false)
    private Card card;
}
