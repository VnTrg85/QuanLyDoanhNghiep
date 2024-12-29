package matecom.matecom.Entity;

import java.sql.Date;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
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
    @JoinColumn(name="grouptchats_id",nullable = false)
    private Groupchats groupchats;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="task_id",nullable = false)
    private Tasks task;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="calendar_id",nullable = false)
    private Calendar calendar;
}
