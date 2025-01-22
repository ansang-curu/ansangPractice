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
public class PageDto {
    private int page;
    private int limit;
    private int totalPages;
    private int totalElements;
    private List<FruitDto> fruits;

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

    public List<FruitDto> getFruits() {
        return fruits;
    }

    public void setFruits(List<FruitDto> fruits) {
        this.fruits = fruits;
    }



}
