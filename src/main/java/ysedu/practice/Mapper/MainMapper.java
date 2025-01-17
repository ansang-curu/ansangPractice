package ysedu.practice.Mapper;

import org.apache.ibatis.annotations.Mapper;
import ysedu.practice.Dto.FruitDto;

@Mapper
public interface MainMapper {
    public void insertItem(FruitDto fruitDto);

}
