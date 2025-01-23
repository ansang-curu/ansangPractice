package ysedu.practice.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ysedu.practice.Dto.SupDto;

import java.util.List;
import java.util.Optional;
@Mapper
public interface SupMapper {
    public void insertSup(SupDto supDto);
    Optional<SupDto> selectSupById(int id);
    List<SupDto> selectSups(@Param("limit") int limit, @Param("offset") int offset);
    void deleteSup(int id);
    void updateSup(SupDto supDto);
    int countTotal();
}
