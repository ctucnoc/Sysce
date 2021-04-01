package com.sys.mype.sysce.pe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_authority",schema = "dbasgu")
public class BUserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_user_authority")
    private int userAuthorityId;

    @Column(name = "sn_active",length = 1)
    private String userAuthorityStatus;

    @ManyToOne
    @JoinColumn(name = "cd_user")
    private BUser bUser;

    @ManyToOne
    @JoinColumn(name = "cd_authority")
    private BAuthority bAuthority;
}
