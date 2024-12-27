package matecom.matecom.Entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private Date date_created;

    @Getter
    @Setter
    private int chat_id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private Users user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "grouptchats_id", nullable = false)
    private Groupchats groupchats;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="task_id",nullable = true)
    private Tasks task;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="calendar_id",nullable = true)
    private Calendar calendar;
}
