package matecom.matecom.API;

import matecom.matecom.DTO.MessageResponseDTO;
import matecom.matecom.Service.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageAPI {
    @Autowired
    private MessageService messageService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/messages/{groupChatId}")
    public ResponseEntity<List<MessageResponseDTO>> getMessages(@PathVariable Integer groupChatId) {
        List<MessageResponseDTO> messages = messageService.getMessages(groupChatId);
        return ResponseEntity.ok(messages);
    }
}
