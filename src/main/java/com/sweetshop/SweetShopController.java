package com.sweetshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SweetShopController {
    private final SweetShop sweetShop = new SweetShop();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sweets", sweetShop.getAllSweets());
        return "sweets";
    }

    @GetMapping("/add")
    public String addSweetForm(Model model) {
        model.addAttribute("sweet", new Sweet(0, "", "", 0, 0));
        return "add-sweet";
    }

    @PostMapping("/add")
    public String addSweet(@ModelAttribute Sweet sweet) {
        sweetShop.addSweet(sweet);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteSweet(@PathVariable int id) {
        sweetShop.deleteSweet(id);
        return "redirect:/";
    }

    @PostMapping("/purchase/{id}")
    public String purchaseSweet(@PathVariable int id, @RequestParam int quantity, Model model) {
        try {
            sweetShop.purchaseSweet(id, quantity);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("sweets", sweetShop.getAllSweets());
        return "sweets";
    }

    @PostMapping("/restock/{id}")
    public String restockSweet(@PathVariable int id, @RequestParam int quantity) {
        sweetShop.restockSweet(id, quantity);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchSweets(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String category,
                               @RequestParam(required = false) Double minPrice,
                               @RequestParam(required = false) Double maxPrice,
                               Model model) {
        List<Sweet> results = sweetShop.getAllSweets();
        if (name != null && !name.isEmpty()) {
            results = sweetShop.searchSweetsByName(name);
        } else if (category != null && !category.isEmpty()) {
            results = sweetShop.searchSweetsByCategory(category);
        } else if (minPrice != null && maxPrice != null) {
            results = sweetShop.searchSweetsByPriceRange(minPrice, maxPrice);
        }
        model.addAttribute("sweets", results);
        return "sweets";
    }

    @GetMapping("/sort")
    public String sortSweets(@RequestParam String by, Model model) {
        List<Sweet> sorted;
        switch (by) {
            case "name":
                sorted = sweetShop.sortSweetsByName();
                break;
            case "price":
                sorted = sweetShop.sortSweetsByPrice();
                break;
            case "quantity":
                sorted = sweetShop.sortSweetsByQuantity();
                break;
            default:
                sorted = sweetShop.getAllSweets();
        }
        model.addAttribute("sweets", sorted);
        return "sweets";
    }


}
