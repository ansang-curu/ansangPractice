package ysedu.practice.Mapper;

import org.apache.ibatis.annotations.Mapper;
import ysedu.practice.Dto.FruitDto;

import java.util.List;

@Mapper
public interface MainMapper {
    public void insertItem(FruitDto fruitDto);
    FruitDto selectItemById(int id);
    List<FruitDto> selectItems();

}
