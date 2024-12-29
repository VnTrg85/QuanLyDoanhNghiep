package matecom.matecom.Service.Check_list_item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matecom.matecom.Entity.Check_list_item;
import matecom.matecom.Repository.Check_list_item_Repository;

@Service
public class Check_list_itemServiceImpl implements Check_list_itemService {
   @Autowired
    private Check_list_item_Repository checkListItemRepository;

    @Override
    public Check_list_item addCheckListItem(Check_list_item item) {
        item.setStatus(false);
        return checkListItemRepository.save(item);
    }

    @Override
    public List<Check_list_item> getAllCheckListItemsByCheckListId(int checkListId) {
        return checkListItemRepository.findAll().stream()
                .filter(item -> item.getCheck_lists().getId() == checkListId)
                .collect(Collectors.toList());
    }

    @Override
    public Check_list_item updateCheckListItem(Check_list_item item) {
        Check_list_item existingItem = checkListItemRepository.findById(item.getId())
            .orElseThrow(() -> new RuntimeException("Checklist item not found"));
        existingItem.setName(item.getName());
        existingItem.setStatus(item.getStatus());
        return checkListItemRepository.save(existingItem);
    }

    @Override
    public void deleteCheckListItem(int id) {
        checkListItemRepository.deleteById(id);
    }

    @Override
    public Check_list_item getCheckListItemById(int id) {
        return checkListItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Checklist item not found"));
    }
}
