package by.itsupportme.sindalouski.sampletask.service;

import by.itsupportme.sindalouski.sampletask.entity.Item;
import by.itsupportme.sindalouski.sampletask.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServiceImpl  implements ItemService{

    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Page<Item> listItems(int page, String sort) {

        Pageable pageable = new PageRequest(page - 1, 5, new Sort(sort));
        return itemRepository.findAll(pageable);
    }

    @Override
    public void add(Item item) throws IOException {

        item.setTitle(item.getTitle());
        item.setText(item.getText());
        item.setCreateDate(LocalDateTime.now());
        itemRepository.save(item);
    }

    @Override
    public void edit(Item item) {

        item = itemRepository.findOne(item.getId());
        item.setTitle(item.getTitle());
        item.setText(item.getText());
        item.setCreateDate(LocalDateTime.now());
        itemRepository.save(item);

    }
}
