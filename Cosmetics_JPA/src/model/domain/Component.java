package model.domain;

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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


//이름으로 사원 검색
//@NamedQuery(query="select e from Employee e where e.ename=:ename" , name="Employee.findByEname")
//@NamedQuery(query= , name="Employee.findByEmpnoAndEname")
@SequenceGenerator(name = "com_seq_gen", sequenceName = "com_seq_id", initialValue = 1, allocationSize = 50)

@Entity
public class Component {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "com_seq_gen")
	@Column(name="com_id")
	private int comid;
	
	@Column(name="com_name")
	private String comname;
	
	@Column(name="function")
	private String function;
	
	@Column(name="risk_degree")
	private int riskdegree;
	
	@Column(name = "harmful")
	private String harmful;
		
	@OneToMany(mappedBy = "com")
	private List<Connection> con;	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Component [comid=");
		builder.append(comid);
		builder.append(", comname=");
		builder.append(comname);
		builder.append(", function=");
		builder.append(function);
		builder.append(", risk_degree=");
		builder.append(riskdegree);
		builder.append(", harmful=");
		builder.append(harmful);
		builder.append("]");
		return builder.toString();
	}

}
