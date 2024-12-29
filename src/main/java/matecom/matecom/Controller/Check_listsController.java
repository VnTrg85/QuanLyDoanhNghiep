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

import matecom.matecom.Entity.Check_lists;
import matecom.matecom.Service.Check_lists.Check_listsService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/checklists")
public class Check_listsController {
    @Autowired
    private Check_listsService checkListService;

    @PostMapping("/{id}")
    public ResponseEntity<Check_lists> addCheckList(@PathVariable int id,@RequestBody Check_lists checkList) {
        Check_lists newCheckList = checkListService.addCheckList(id, checkList);
        return ResponseEntity.ok(newCheckList);
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<List<Check_lists>> getCheckListsByCard(@PathVariable int cardId) {
        List<Check_lists> checkLists = checkListService.getAllCheckListsByCardId(cardId);
        return ResponseEntity.ok(checkLists);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Check_lists> updateCheckList(@PathVariable int id, @RequestBody Check_lists checkList) {
        checkList.setId(id);
        Check_lists updatedCheckList = checkListService.updateCheckList(checkList);
        return ResponseEntity.ok(updatedCheckList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckList(@PathVariable int id) {
        checkListService.deleteCheckList(id);
        return ResponseEntity.noContent().build();
    }
}
