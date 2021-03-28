package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subsidiary",schema = "sysce")
public class BSubsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_subsidiary")
    private int subsidiaryId;

    @Column(name = "nm_subsidiary",length = 90)
    private String subsidiaryName;

    @Column(name = "ds_address",length = 150)
    private String subsidiaryAddress;

    @Column(name = "nr_phone",length = 9)
    private String subsidiaryNumberPhone;

    @Column(name = "sn_active",length = 1)
    private String subsidiaryStatus;

    @ManyToOne
    @JoinColumn(name = "cd_enterprise")
    private BEnterprise bEnterprise;
}
