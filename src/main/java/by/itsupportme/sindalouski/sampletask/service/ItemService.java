package by.itsupportme.sindalouski.sampletask.service;

import by.itsupportme.sindalouski.sampletask.entity.Item;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    Page<Item> listItems(int page, String sort);

    void add(Item item) throws IOException;

    void edit(Item item);
}
