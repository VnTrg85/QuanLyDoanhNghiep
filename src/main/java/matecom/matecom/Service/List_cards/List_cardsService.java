package matecom.matecom.Service.List_cards;

import java.util.List;

import matecom.matecom.Entity.List_cards;

public interface List_cardsService {
    public List_cards addListCard(int taskId, List_cards listCard);
    public List<List_cards> getAllListCardsByTaskId(int taskId);
    public List_cards updateListCard(int id, List_cards list_card);
    public void deleteListCard(int id);
}
