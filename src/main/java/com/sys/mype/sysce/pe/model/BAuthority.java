package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authority",schema = "dbasgu")
public class BAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_autority")
    private int authorityId;

    @Column(name = "nm_authority",length = 30)
    private String authorityName;

    @Column(name = "ds_authority",length = 90)
    private String authorityDescription;

    @Column(name = "sn_active",length = 1)
    private String authorityStatus;
}
