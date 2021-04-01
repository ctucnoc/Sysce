package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "gender",schema = "sysce")
public class BGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_gender")
    private int genderId;

    @Column(name = "ds_gender",length = 30)
    private String genderDescription;

    @Column(name = "sn_active",length = 1)
    private String genderStatus;
}
