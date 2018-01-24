package by.itsupportme.sindalouski.sampletask.controller;

import by.itsupportme.sindalouski.sampletask.entity.Item;
import by.itsupportme.sindalouski.sampletask.repository.ItemRepository;
import by.itsupportme.sindalouski.sampletask.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/item")
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	private final ItemService itemService;
	private final ItemRepository itemRepository;

	public ItemController(ItemService itemService, ItemRepository itemRepository) {
		this.itemService = itemService;
		this.itemRepository = itemRepository;
	}

	@GetMapping(value = "/add")
	public ModelAndView createItemView() {
		ModelAndView modelAndView = new ModelAndView("add");
		modelAndView.addObject("item", new Item());
		return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView addItem(@Valid Item item, BindingResult result) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form");
			modelAndView.setViewName("add");
			modelAndView.addObject("item", item);
			return modelAndView;
		}
		itemService.add(item);
		modelAndView.setViewName("redirect:/home");
		logger.info("Form submitted successfully.");
		return modelAndView;
	}

	@GetMapping(value = "/viewpage/{id}")
	public String guestIssueView(@PathVariable("id") Integer id, Model model) throws IOException {
		model.addAttribute("item", itemRepository.findOne(id));
		return "viewpage";
	}
}
