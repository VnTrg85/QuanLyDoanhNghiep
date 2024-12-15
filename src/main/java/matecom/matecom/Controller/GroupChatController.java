package matecom.matecom.Controller;

import matecom.matecom.DTO.MessageRequestDTO;
import matecom.matecom.DTO.MessageResponseDTO;
import matecom.matecom.Service.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupchat")
public class GroupChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/groupChat")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageRequestDTO message) {
        messageService.saveMessage(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/messages/{groupChatId}")
    public ResponseEntity<List<MessageResponseDTO>> getMessages(@PathVariable Integer groupChatId) {
        List<MessageResponseDTO> messages = messageService.getMessages(groupChatId);
        return ResponseEntity.ok(messages);
    }
}
