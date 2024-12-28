package matecom.matecom.Service.GroupChat;

import matecom.matecom.DTO.GroupChatDTO;

public interface GroupChatService {
    void addGroupChat(GroupChatDTO groupChatDTO);
    void deleteGroupChat(int groupChatID);
}
