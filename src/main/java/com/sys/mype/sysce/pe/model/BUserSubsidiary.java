package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_subsidiary",schema = "dbasgu")
public class BUserSubsidiary {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_user_subsidiary")
    private int userSubsidiaryId;

    @Column(name = "sn_active",length = 1)
    private String userSubsidiaryStatus;
	
    @ManyToOne
    @JoinColumn(name = "cd_user")
    private BUser bUser;
    
    @ManyToOne
    @JoinColumn(name = "cd_subsidiary")
    private BSubsidiary bSubsidiary;

}
