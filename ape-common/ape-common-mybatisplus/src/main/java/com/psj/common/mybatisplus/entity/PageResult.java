package com.psj.common.mybatisplus.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-10:17
 * @description TODO
 */
@Data
public class PageResult<T> implements Serializable {
    private Long total;
    private Long size;
    private Long current;
    private Long pages;
    private List<T> records= Collections.emptyList();

    public  void loadData(IPage<T> pageData){
        this.setCurrent(pageData.getCurrent());
        this.setTotal(pageData.getTotal());
        this.setSize(pageData.getSize());
        this.setPages(pageData.getPages());
        this.setRecords(pageData.getRecords());
    }
}
