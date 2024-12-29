package matecom.matecom.Service.Check_lists;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matecom.matecom.Entity.Check_list_item;
import matecom.matecom.Entity.Check_lists;
import matecom.matecom.Repository.Check_listsRepository;
import matecom.matecom.Repository.Check_list_item_Repository;
import matecom.matecom.Repository.CardRepository;

@Service
public class Check_listServiceImpl implements Check_listsService {
    @Autowired
    private Check_listsRepository checkListsRepository;

    @Autowired
    private Check_list_item_Repository checkListItemRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Check_lists addCheckList(int id, Check_lists checkList) {
        checkList.setStatus(false);
        checkList.setCard(cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("List_card not found!")));
        return checkListsRepository.save(checkList);
    }

    @Override
    public List<Check_lists> getAllCheckListsByCardId(int cardId) {
        return checkListsRepository.findAll().stream()
                .filter(checkList -> checkList.getCard().getId() == cardId)
                .collect(Collectors.toList());
    }

    @Override
    public Check_lists updateCheckList(Check_lists checkList) {
        Check_lists existingChecklist = checkListsRepository.findById(checkList.getId())
            .orElseThrow(() -> new RuntimeException("Checklist not found"));
        existingChecklist.setName(checkList.getName());
        existingChecklist.setStatus(checkList.getStatus());
        return checkListsRepository.save(existingChecklist);
    }

    @Override
    public void deleteCheckList(int id) {
        checkListsRepository.deleteById(id);
    }

    @Override
    public void updateCheckListStatus(int checkListId) {
        Check_lists checkList = checkListsRepository.findById(checkListId)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));

        List<Check_list_item> checkListItems = checkListItemRepository.findAll()
                .stream()
                .filter(item -> item.getCheck_lists().getId() == checkListId)
                .toList();

        boolean allItemsCompleted = checkListItems.stream()
                .allMatch(Check_list_item::getStatus);

        checkList.setStatus(allItemsCompleted);
        checkListsRepository.save(checkList);
    }
}
