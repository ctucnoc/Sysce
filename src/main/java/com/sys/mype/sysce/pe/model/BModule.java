package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "module",schema = "dbasgu")
public class BModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_module")
    private int moduleId;

    @Column(name = "nm_module",length = 30)
    private String moduleName;

    @Column(name = "ds_module",length = 90)
    private String moduleDescription;

    @Column(name = "ds_code",length = 10)
    private String moduleCode;

    @Column(name = "img_module",length = 60)
    private String moduleIcon;

    @Column(name = "sn_active",length = 1)
    private String moduleStatus;
}
