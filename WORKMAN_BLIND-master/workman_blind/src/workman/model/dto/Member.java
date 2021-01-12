package workman.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQuery(name="findmemid", query="select m.userid from Member m where m.userid = :userid")
@NamedQuery(name="findmempw", query="select m.userpw from Member m where m.userid = :userid")

@Entity
public class Member {
	
	@Id
	@Column(name = "user_id")
	private String userid;
	
	@ManyToOne // 회사명
	@JoinColumn(name="company_name")
	private Company companyname;
	
	@Column(name = "user_pw")
	private String userpw;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "user_num")
	private String usernum;
	
	@OneToMany(mappedBy = "userid")
	private List<ParttimeEval> parttimeevals;

}