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
@Table(name = "category_subsidiary", schema = "dbasgu")
public class BCategorySubsidiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_category_subsidiary")
	private int categorySubsidiaryId;

	@ManyToOne
	@JoinColumn(name = "cd_category")
	private BCategory bCategory;

	@ManyToOne
	@JoinColumn(name = "cd_subsidiary")
	private BSubCategory bSubCategory;
	
	@Column(name = "sn_active",length = 1)
	private String categorySubsidiaryStatus;

}
