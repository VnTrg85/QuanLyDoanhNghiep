package matecom.matecom.Converter;

import matecom.matecom.DTO.MessageRequestDTO;
import matecom.matecom.Entity.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Message ConvertToMessage(MessageRequestDTO message) {
        return modelMapper.map(message, Message.class);
    }
}
