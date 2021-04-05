package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "screen",schema = "dbasgu")
public class BScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_screen")
    private int screenId;

    @Column(name = "nm_screen",length = 30)
    private String screenName;

    @Column(name = "ds_screen",length = 90)
    private String screenDescription;

    @Column(name = "img_screen",length = 60)
    private String screenIcon;

    @Column(name = "ds_code",length = 10)
    private String screenCode;

    @Column(name = "sn_active",length = 1)
    private String screenStatus;
}
