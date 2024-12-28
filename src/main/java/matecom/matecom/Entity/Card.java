package matecom.matecom.Entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Date date_start;

    @Getter
    @Setter
    private Date date_end;

    @Getter
    @Setter
    private String description;

    @ManyToOne 
    @JoinColumn(name="list_card_id",nullable = false)
    private List_cards list_cards;

}
