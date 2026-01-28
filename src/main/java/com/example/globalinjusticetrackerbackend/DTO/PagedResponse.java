package com.example.globalinjusticetrackerbackend.DTO;

import org.springframework.context.annotation.Bean;

import java.util.List;


public class PagedResponse<T>{

    private final List<T> items;
    private final int page;
    private final int size;
    private final long totalItems;
    private final int totalPages;
    private final Boolean hasNext;

    public PagedResponse(List<T> items, int page, int size, long totalItems, int totalPages,  Boolean hasNext) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
    }

    public List<T> getItems() {
        return items;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

}
