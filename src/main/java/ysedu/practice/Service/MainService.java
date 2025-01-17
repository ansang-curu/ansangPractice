package ysedu.practice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysedu.practice.Dto.FruitDto;
import ysedu.practice.Mapper.MainMapper;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public void createItem(FruitDto fruitDto){
        mainMapper.insertItem(fruitDto);
    }
}
