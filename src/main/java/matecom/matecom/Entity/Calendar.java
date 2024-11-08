package matecom.matecom.Entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Date time_start;

    @Getter
    @Setter
    private Date time_end;

    @Getter
    @Setter
    private String work_content;

    @Getter
    @Setter
    private String report_content;

    @ManyToOne 
    @JoinColumn(name="user_id",nullable  = false)
    private Users user;

}
