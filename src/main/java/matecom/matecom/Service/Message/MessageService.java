package matecom.matecom.Service.Message;

import matecom.matecom.DTO.MessageRequestDTO;
import matecom.matecom.DTO.MessageResponseDTO;
import matecom.matecom.Entity.Message;

import java.util.List;

public interface MessageService {
    void saveMessage(MessageRequestDTO messageRequest);
    List<MessageResponseDTO> getMessages(int groupChatId);
}
