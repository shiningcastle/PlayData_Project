package workman.model.dto;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@NamedQuery(name="findcomname", query="select c.companyname from Company c where c.companyname = :companyname")
@NamedQuery(name="findcompw", query="select c.companypw from Company c where c.companyname = :companyname")

@Entity
public class Company {

	@Id
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name = "company_pw")
	private String companypw;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "company_loc")
	private String companyloc;
	
	@Column(name = "company_num")
	private String companynum;
	
	@OneToMany(mappedBy = "companyname")
	private List<Member> Members;
	
	@OneToMany(mappedBy = "companyname")
	private List<ParttimeList> parttimelists;
	
	@OneToMany(mappedBy = "companyname")
	private List<ParttimeEval> parttimeevals;
		
}