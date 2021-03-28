package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category",schema = "sysce")
public class BCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_category")
    private int categoryId;

    @Column(name = "ds_category",length = 30)
    private String categoryDescription;

    @Column(name = "sn_active",length = 1)
    private String categoryStatus;

    @ManyToOne
    @JoinColumn(name = "cd_subsidiary")
    private BSubsidiary bSubsidiary;
}
