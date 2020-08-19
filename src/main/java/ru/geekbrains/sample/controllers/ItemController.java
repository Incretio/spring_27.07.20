package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dto.ItemDTO;
import ru.geekbrains.sample.services.ItemService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping ("/{id}")
    public ItemDTO getBookPage(@PathVariable String id) {
        return itemService.getItem(UUID.fromString(id));
    }

    @PostMapping
    public void createItem(@RequestBody ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
    }

    @PutMapping
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(UUID.fromString(id));
    }

}
