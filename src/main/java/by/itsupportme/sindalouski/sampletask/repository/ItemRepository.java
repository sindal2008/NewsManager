package by.itsupportme.sindalouski.sampletask.repository;

import by.itsupportme.sindalouski.sampletask.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Integer> {
}
