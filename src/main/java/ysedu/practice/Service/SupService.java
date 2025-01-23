package ysedu.practice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysedu.practice.Dto.PageDto;
import ysedu.practice.Dto.SupDto;

import ysedu.practice.Mapper.SupMapper;

import java.util.List;

@Service
public class SupService {
    @Autowired
    private SupMapper supMapper;
    //삽입 기능
    public void createSup(SupDto supDto){
        supMapper.insertSup(supDto);
    }
    //    id로 한개 조회 상세페이지
    public SupDto selectSupById(int id){
        return supMapper.selectSupById(id).orElseThrow(()->new IllegalStateException(String.format("id %d번은 없습니다.",id)));
    }
    //    전체 조회 목록
    public PageDto<SupDto> selectsups(int page, int limit) {
        int offset=(page-1)*limit;
        List<SupDto> sups =supMapper.selectSups(limit,offset);
        int totalElements = supMapper.countTotal();
//        int totalPages= (int) Math.ceil((double) totalElements/limit);
        PageDto<SupDto> pageDto = new PageDto(page,limit,totalElements,sups);
        return pageDto;
    }
    //    삭제 기능
    public void deleteSup(int id){
        supMapper.deleteSup(id);
    }
    //    수정 기능
    public void updateSup(SupDto supDto){
        supMapper.updateSup(supDto);
    }

}
