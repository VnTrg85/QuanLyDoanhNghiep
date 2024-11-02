package matecom.matecom.Entity;

import java.sql.Date;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import matecom.matecom.DTO.Groupchat_User_DTO;

public class Groupchat_user {
    @Id
    private Groupchat_User_DTO id;
    @Getter
    @Setter
    private Date date_created;

}
