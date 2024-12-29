package matecom.matecom.DTO;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Embeddable
public class Groupchat_User_DTO {
    @Getter
    @Setter
    private int groupchat_id;
    @Getter
    @Setter
    private int user_id;

}
