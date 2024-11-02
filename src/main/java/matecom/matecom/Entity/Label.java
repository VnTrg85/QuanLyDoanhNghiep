package matecom.matecom.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class Label {
    @Id
    private int id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String color;
}
