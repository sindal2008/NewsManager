package by.itsupportme.sindalouski.sampletask.controller;

import by.itsupportme.sindalouski.sampletask.entity.Item;
import by.itsupportme.sindalouski.sampletask.repository.ItemRepository;
import by.itsupportme.sindalouski.sampletask.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Handles requests for main page
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    /** Service performs all retrieval/manipulation work with data */
    ItemService itemService;
    ItemRepository itemRepository;

    public IndexController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    /**
     * Retrieve all news items
     */
    @GetMapping(name = "/")
    public String allNews(Model model, HttpSession session,
                          @RequestParam(name = "page", defaultValue = "1") int page,
                          @RequestParam(name = "sort", defaultValue = "createDate") String sort){

        Page<Item> items = itemService.listItems(page, sort);
        model.addAttribute("items", items.getContent());
        model.addAttribute("totalPages", items.getTotalPages());
        model.addAttribute("page", page);

        return "home";
    }
}
