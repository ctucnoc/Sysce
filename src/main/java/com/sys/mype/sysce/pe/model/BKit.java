package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "kit",schema = "sysce")
public class BKit {

    @Id
    @Column(name = "cd_kit",length = 16)
    private String kitId;

    @Column(name = "cd_product",length = 16)
    private String productId;

    @Column(name = "nm_kit",length = 90)
    private String kitName;

    @Column(name = "sn_active",length = 1)
    private String kitStatus;
}
