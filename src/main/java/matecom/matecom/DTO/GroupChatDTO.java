package matecom.matecom.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GroupChatDTO {
    private int id;

    @NotNull(message = "Name is null")
    private String name;
}
