package com.anneng.net.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Page<T> {

    private int offset = 0;
    private int size = 10;
    private T data;
    private long total = 0;
    private int page = 1;
    private long totalPage = 0;

    public Page(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public long getTotalPage() {
        if (total <= size) return 1;
        if (total % size != 0) return total / size + 1;
        return total / size;
    }

    public int getOffset() {
        return (this.page - 1) * this.size;
    }
}

