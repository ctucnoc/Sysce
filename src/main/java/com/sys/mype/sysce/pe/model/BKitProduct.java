package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "kit_product",schema = "sysce")
public class BKitProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kitProductId;

    @Column(name = "sn_active",length = 1)
    private String kitProductStatus;

    @ManyToOne
    @JoinColumn(name = "cd_product")
    private BProduct bProduct;

    @ManyToOne
    @JoinColumn(name = "cd_kit")
    private BKit bKit;
}
