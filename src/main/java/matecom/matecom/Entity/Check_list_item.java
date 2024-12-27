package matecom.matecom.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Check_list_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="check_list_id")
    private Check_lists check_lists;
}
