package workman.model.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "partlist_seq_gen", sequenceName = "partlist_seq_num", initialValue = 1, allocationSize = 50)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQuery(name="findptlist", query="select p from ParttimeList p where p.listnum = :listnum")

@Entity
public class ParttimeList implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partlist_seq_gen")
	@Column(name="list_num")
	private int listnum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="company_name")
	private Company companyname;
	
	@Column(name="work_time")
	private String worktime;
	
	@Column(name="hourly_wage")
	private int hourlywage;
	
	@Column(name="work_period")
	private String workperiod;
	
	@Column(name="objective")
	private String objective;
	
}

