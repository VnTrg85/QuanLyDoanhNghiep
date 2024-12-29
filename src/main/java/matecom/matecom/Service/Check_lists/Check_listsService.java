package matecom.matecom.Service.Check_lists;

import java.util.List;

import matecom.matecom.Entity.Check_lists;

public interface Check_listsService {
    public Check_lists addCheckList(int id, Check_lists checkList);
    public List<Check_lists> getAllCheckListsByCardId(int cardId);
    public Check_lists updateCheckList(Check_lists checkList);
    public void deleteCheckList(int id);
    public void updateCheckListStatus(int checkListId);
}