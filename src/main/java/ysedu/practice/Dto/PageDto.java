package ysedu.practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class PageDto<T> {

    private int page;
    private int limit;
    private int totalPages;
    private int totalElements;
    private List<T> content;
//    private List<SupDto> sups;

    public PageDto(int page, int limit, int totalElements, List<T> content) {
        this.page = page;
        this.limit = limit;
        this.totalPages = (int) Math.ceil((double) totalElements / limit);
        this.totalElements = totalElements;
        this.content = content;
    }


    public List<T> getFruits() {
        return content;
    }

//    public void setFruits(List<FruitDto> fruits) {
//        this.fruits = fruits;
//    }



}
