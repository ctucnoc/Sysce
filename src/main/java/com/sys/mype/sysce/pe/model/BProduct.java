package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product",schema = "sysce")
public class BProduct {

    @Id
    @Column(name = "cd_product",length = 16)
    private String productId;

    @Column(name = "nm_product",length = 90)
    private String productName;

    @Column(name = "nm_product_summary",length = 30)
    private String productNameSummary;

    @Column(name = "sn_kit",length = 1)
    private String productKit;

    @Column(name = "sn_generic",length = 1)
    private String productGeneric;

    @Column(name = "sn_batch",length = 1)
    private String productBatch;

    @Column(name = "sn_expiration_date",length = 1)
    private String productExpirationDate;

    @Column(name = "sn_refrigeration",length = 1)
    private String productRefrigeration;

    @Column(name = "sn_active",length = 1)
    private String productStatus;

    @ManyToOne
    @JoinColumn(name = "cd_sub_category")
    private BSubCategory bSubCategory;

}
