package matecom.matecom.API;

import matecom.matecom.DTO.ErrorDTO;
import matecom.matecom.DTO.GroupChatDTO;
import matecom.matecom.DTO.MessageResponseDTO;
import matecom.matecom.Service.GroupChat.GroupChatService;
import matecom.matecom.Service.Message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/groupChat")
public class GroupChatAPI {

    @Autowired
    private GroupChatService groupChatService;

    @PostMapping
    public ResponseEntity<ErrorDTO> addOrUpdateGroupChat(@RequestBody GroupChatDTO groupChatDTO, BindingResult bindingResult) {
        try{
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
                return ResponseEntity.badRequest().body(new ErrorDTO(errors));
            }
            groupChatService.addGroupChat(groupChatDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(Collections.singletonList(e.getMessage())));

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        groupChatService.deleteGroupChat(id);
        return ResponseEntity.noContent().build();
    }
}
