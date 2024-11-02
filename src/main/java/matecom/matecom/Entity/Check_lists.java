package matecom.matecom.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

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
