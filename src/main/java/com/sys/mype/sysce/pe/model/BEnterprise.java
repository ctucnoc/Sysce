package com.sys.mype.sysce.pe.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "enterprise",schema = "sysce")
public class BEnterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_enterprise")
    private int enterpriseId;

    @Column(name = "nm_enterprise",length = 90)
    private String enterpriseName;

    @Column(name = "im_enterprese",length = 90)
    private String enterpriseImg;

    @Column(name = "ds_address",length = 150)
    private String enterpriseAddress;

    @Column(name = "nr_phone",length = 9)
    private String enterpriseNumberPhone;

    @Column(name = "ds_ruc",length = 11)
    private String enterpriseRuc;

    @Column(name = "ds_mail",length = 60)
    private String enterpriseMail;

    @Column(name = "sn_active",length = 1)
    private String enterpriseStatus;

}
