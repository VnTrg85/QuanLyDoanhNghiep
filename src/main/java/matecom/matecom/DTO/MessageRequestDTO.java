package matecom.matecom.DTO;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class MessageRequestDTO {
    @Getter
    @Setter
    private Integer groupChat_Id;
    @Getter
    @Setter
    private Integer user_Id;
    @Getter
    @Setter
    @NonNull
    private String content;
}
