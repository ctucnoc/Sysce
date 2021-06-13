package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "kit_product",schema = "sysce")
public class BKitProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_kit_product")
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
