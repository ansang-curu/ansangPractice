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



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getFruits() {
        return content;
    }

//    public void setFruits(List<FruitDto> fruits) {
//        this.fruits = fruits;
//    }



}
