package matecom.matecom.WebSocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import matecom.matecom.DTO.MessageRequestDTO;
import matecom.matecom.Entity.Message;
import matecom.matecom.Service.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.imageio.IIOException;
import java.io.IOException;

@Slf4j
public class DataHandle  extends TextWebSocketHandler {
    @Autowired
    private MessageService messageService;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        MessageRequestDTO messageRequestDTO = objectMapper.readValue(message.getPayload().toString(), MessageRequestDTO.class);

        // Lưu tin nhắn xuống database
        Message savedMessage = messageService.saveMessage(messageRequestDTO);

        // Đẩy tin nhắn vừa lưu ra lại
        session.sendMessage(new TextMessage(savedMessage.getContent()));
    }

}
