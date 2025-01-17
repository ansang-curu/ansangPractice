package ysedu.practice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysedu.practice.Dto.FruitDto;
import ysedu.practice.Mapper.MainMapper;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;
//삽입 기능
    public void createItem(FruitDto fruitDto){
        mainMapper.insertItem(fruitDto);
    }
//    id로 한개 조회 상세페이지
    public FruitDto selectItemById(int id){
        return mainMapper.selectItemById(id).orElseThrow(()->new IllegalStateException(String.format("id %d번은 없습니다.",id)));
    }
//    전체 조회 목록
    public List<FruitDto> selectItems(){
        return mainMapper.selectItems();
    }
}
