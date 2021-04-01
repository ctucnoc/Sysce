package com.sys.mype.sysce.pe.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user",schema = "dbasgu")
public class BUser {

    @Id
    @Column(name = "cd_user",length = 15)
    private String userId;

    @Column(name = "nm_user",length = 90)
    private String userName;

    @Column(name = "cd_password",length = 200)
    private String userPassword;

    @Column(name = "tp_privilege",length = 1)
    private String userPrivilege;

    @Column(name = "sn_active",length = 1)
    private String userStatus;

    @ManyToOne
    @JoinColumn(name = "cd_person")
    private BPerson bPerson;

}
