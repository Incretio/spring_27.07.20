package ru.geekbrains.sample.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.sample.dto.ItemDTO;
import ru.geekbrains.sample.persistence.entities.Item;

import java.util.List;

@Mapper
public interface ItemMapper {

    ItemMapper MAPPER = Mappers.getMapper(ItemMapper.class);

    Item toItem(ItemDTO itemDto);
    List<Item> toItemList(List<ItemDTO> itemDtoList);

    @InheritInverseConfiguration
    ItemDTO fromItem(Item item);
    List<ItemDTO> fromItemList(List<Item> itemList);

}
