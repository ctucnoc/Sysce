package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "module_screen",schema = "dbasgu")
public class BModuleScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_module_screen")
    private int moduleScreenId;

    @Column(name = "sn_active",length = 1)
    private String moduleScreenStatus;

    @ManyToOne
    @JoinColumn(name = "cd_module")
    private BModule bModule;

    @ManyToOne
    @JoinColumn(name = "cd_screen")
    private BScreen bScreen;
}
