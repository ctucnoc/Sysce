package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sub_category",schema = "sysce")
public class BSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_sub_category")
    private int subCategoryId;

    @Column(name = "ds_sub_category",length = 30)
    private String subCategoryDescription;

    @Column(name = "sn_active",length = 1)
    private String subCategoryStatus;

    @ManyToOne
    @JoinColumn(name = "cd_category")
    private BCategory bCategory;
}
