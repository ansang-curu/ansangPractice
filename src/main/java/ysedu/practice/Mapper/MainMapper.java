package ysedu.practice.Mapper;

import org.apache.ibatis.annotations.Mapper;
import ysedu.practice.Dto.FruitDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainMapper {
    public void insertItem(FruitDto fruitDto);
    Optional<FruitDto> selectItemById(int id);
    List<FruitDto> selectItems();

}
