package matecom.matecom.DTO;

import lombok.Getter;
import lombok.Setter;
import matecom.matecom.Entity.Message;

import java.time.LocalDateTime;

public class MessageResponseDTO {
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private String senderName;
    @Getter
    @Setter
    private LocalDateTime timestamp;
    public MessageResponseDTO(String content, String senderName, LocalDateTime timestamp) {
        this.content = content;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }
}
