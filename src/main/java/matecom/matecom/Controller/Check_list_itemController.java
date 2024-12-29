package matecom.matecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matecom.matecom.Entity.Check_list_item;
import matecom.matecom.Entity.Check_lists;
import matecom.matecom.Service.Check_list_item.Check_list_itemService;
import matecom.matecom.Service.Check_lists.Check_listsService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/checklists")
public class Check_list_itemController {
    @Autowired
    private Check_list_itemService checkListItemService;

    @Autowired
    private Check_listsService checkListService;

    @PostMapping("/{checkListId}/items")
    public ResponseEntity<Check_list_item> addCheckListItem(@PathVariable int checkListId, @RequestBody Check_list_item item) {
        item.setCheck_lists(new Check_lists());
        item.getCheck_lists().setId(checkListId);
        Check_list_item newItem = checkListItemService.addCheckListItem(item);
        checkListService.updateCheckListStatus(checkListId);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping("/{checkListId}/items")
    public ResponseEntity<List<Check_list_item>> getAllCheckListItems(@PathVariable int checkListId) {
        List<Check_list_item> items = checkListItemService.getAllCheckListItemsByCheckListId(checkListId);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Check_list_item> updateCheckListItem(@PathVariable int id, @RequestBody Check_list_item item) {
        item.setId(id);
        Check_list_item updatedItem = checkListItemService.updateCheckListItem(item);
        checkListService.updateCheckListStatus(item.getCheck_lists().getId());
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteCheckListItem(@PathVariable int id) {
        Check_list_item item = checkListItemService.getCheckListItemById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        checkListItemService.deleteCheckListItem(id);
        checkListService.updateCheckListStatus(item.getCheck_lists().getId());
        return ResponseEntity.noContent().build();
    }
}
