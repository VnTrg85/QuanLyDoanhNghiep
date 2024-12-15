package matecom.matecom.Service.Message;

import matecom.matecom.Converter.MessageConverter;
import matecom.matecom.DTO.MessageRequestDTO;
import matecom.matecom.DTO.MessageResponseDTO;
import matecom.matecom.Entity.Groupchats;
import matecom.matecom.Entity.Message;
import matecom.matecom.Entity.Users;
import matecom.matecom.Repository.GroupchatRepository;
import matecom.matecom.Repository.MessageRepository;
import matecom.matecom.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageConverter messageConverter;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private GroupchatRepository groupchatRepository;
    public void saveMessage(MessageRequestDTO messageRequest) {
        Message message = new Message();
        message.setContent(messageRequest.getContent());
        Groupchats groupchat = groupchatRepository.findById(
                messageRequest.getGroupChat_Id())
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Users user = usersRepository.findById(
                messageRequest.getUser_Id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        message.setGroupchats(groupchat);
        message.setUser(user);
        messageRepository.save(message);
    }

    public List<MessageResponseDTO> getMessages(int groupChatId) {
        List<Message> messages = messageRepository.findByGroupchats_Id(groupChatId);
        return messages.stream()
                .map(msg -> new MessageResponseDTO(
                        msg.getContent(),
                        msg.getUser().getUsername(),
                        msg.getDate_created().toLocalDate().atStartOfDay()))
                .collect(Collectors.toList());
    }

}
