package matecom.matecom.DTO;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class MessageRequestDTO {
    @Getter
    @Setter
    private int  id;
    @Getter
    @Setter
    private Integer groupChat_Id;
    @Getter
    @Setter
    private Integer userId;
    @Getter
    @Setter
    @NonNull
    private String content;
}
