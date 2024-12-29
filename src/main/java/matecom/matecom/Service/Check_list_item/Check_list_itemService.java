package matecom.matecom.Service.Check_list_item;

import java.util.List;

import matecom.matecom.Entity.Check_list_item;

public interface Check_list_itemService {
    public Check_list_item addCheckListItem(Check_list_item checkListItem);
    public List<Check_list_item> getAllCheckListItemsByCheckListId(int checkListId);
    public Check_list_item updateCheckListItem(Check_list_item item);
    public void deleteCheckListItem(int id);
    public Check_list_item getCheckListItemById(int id);
}
