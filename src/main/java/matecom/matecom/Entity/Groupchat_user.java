package matecom.matecom.Entity;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import matecom.matecom.DTO.Groupchat_User_DTO;

@Entity
@Data
public class Groupchat_user {
    @EmbeddedId
    private Groupchat_User_DTO id;
    @Getter
    @Setter
    private Date date_created;

}
