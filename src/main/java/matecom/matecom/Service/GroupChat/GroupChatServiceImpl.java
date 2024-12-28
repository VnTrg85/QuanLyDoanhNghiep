package matecom.matecom.Service.GroupChat;

import matecom.matecom.Converter.GroupChatEntityConverter;
import matecom.matecom.DTO.GroupChatDTO;
import matecom.matecom.Entity.Groupchats;
import matecom.matecom.Repository.GroupchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupChatServiceImpl implements GroupChatService{
    @Autowired
    private GroupChatEntityConverter groupChatEntityConverter;
    @Autowired
    private GroupchatRepository groupchatRepository;

    // Kiểm tra tồn tại group chat
    public void addGroupChat(GroupChatDTO groupChatDTO) {
        if (groupchatRepository.existsByName(groupChatDTO.getName())) {
            throw new RuntimeException("Group chat already exists");
        }
        Groupchats groupchats = groupChatEntityConverter.convertToGroupChatEntity(groupChatDTO);
        groupchatRepository.save(groupchats);
    }

    @Override
    public void deleteGroupChat(int groupChatID) {
        groupchatRepository.deleteById(groupChatID);
    }
}
