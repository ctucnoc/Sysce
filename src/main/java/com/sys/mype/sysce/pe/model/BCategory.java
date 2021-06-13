package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category",schema = "sysce")
@Data
public class BCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_category")
    private int categoryId;

   
    @Column(name = "ds_category",length = 30)
    private String categoryDescription;

    @Column(name = "sn_active",length = 1)
    private String categoryStatus;
}
