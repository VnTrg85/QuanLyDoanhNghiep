package matecom.matecom.Converter;

import matecom.matecom.DTO.GroupChatDTO;
import matecom.matecom.Entity.Groupchats;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupChatEntityConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Groupchats convertToGroupChatEntity (GroupChatDTO groupChatDTO) {
        return modelMapper.map(groupChatDTO, Groupchats.class);
    }
}
