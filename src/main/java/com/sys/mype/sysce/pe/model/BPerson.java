package com.sys.mype.sysce.pe.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "person",schema = "sysce")
public class BPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_person")
    private int personId;

    @Column(name = "ds_document_type",length = 1)
    private String personDocumentType;

    @Column(name = "nr_document",length = 15)
    private String personDocumentNumber;

    @Column(name = "nm_person",length = 60)
    private String personName;

    @Column(name = "nm_first_sur",length = 60)
    private String personFirstSurName;

    @Column(name = "nm_second_sur",length = 60)
    private String personSecondSurName;

    @Column(name = "ds_address",length = 150)
    private String personAddress;

    @Column(name = "ds_mail",length = 60)
    private String personMail;

    @Temporal(TemporalType.DATE)
    private Date personDateBirth;

    @ManyToOne
    @JoinColumn(name = "cd_gender")
    private BGender bGender;
}
