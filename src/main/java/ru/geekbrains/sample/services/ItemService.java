package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dto.ItemDTO;
import ru.geekbrains.sample.mappers.ItemMapper;
import ru.geekbrains.sample.persistence.repositories.ItemRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDTO> getAllItems() {
        return ItemMapper.MAPPER.fromItemList(itemRepository.findAll());
    }

    public ItemDTO getItem(UUID id) {
        return ItemMapper.MAPPER.fromItem(itemRepository.findById(id).get());
    }

    public void createItem(ItemDTO itemDTO) {
        itemRepository.save(ItemMapper.MAPPER.toItem(itemDTO));
    }

    public void updateItem(ItemDTO itemDTO) {
        itemRepository.save(ItemMapper.MAPPER.toItem(itemDTO));
    }

    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }

}