package matecom.matecom.Service.List_cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matecom.matecom.Entity.List_cards;
import matecom.matecom.Repository.List_cardsRepository;
import matecom.matecom.Repository.TasksRepository;

@Service
public class List_cardsServiceImpl implements List_cardsService {
    @Autowired
    private List_cardsRepository listCardsRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List_cards addListCard(int taskId, List_cards listCard) {
        listCard.setTasks(tasksRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found!")));
        return listCardsRepository.save(listCard);
    }

    @Override
    public List<List_cards> getAllListCardsByTaskId(int taskId) {
        return listCardsRepository.findAll().stream()
                .filter(listCard -> listCard.getTasks().getId() == taskId)
                .toList();
    }

    @Override
    public List_cards updateListCard(int id, List_cards list_card) {
        List_cards updatelList_cards = listCardsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("List_card not found!"));
        updatelList_cards.setName(list_card.getName());
        return listCardsRepository.save(updatelList_cards);
    }

    @Override
    public void deleteListCard(int id) {
        if (!listCardsRepository.existsById(id)) {
            throw new RuntimeException("List_card not found!");
        }
        listCardsRepository.deleteById(id);
    }
}
