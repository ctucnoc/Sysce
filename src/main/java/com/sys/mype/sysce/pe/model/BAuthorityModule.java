package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authority_module",schema = "dbasgu")
public class BAuthorityModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_authority_module")
    private int authorityModuleId;

    @Column(name = "sn_active",length = 1)
    private String authorityModuleStatus;

    @ManyToOne
    @JoinColumn(name = "cd_authority")
    private BAuthority bAuthority;

    @ManyToOne
    @JoinColumn(name = "cd_module")
    private BModule bModule;
}
