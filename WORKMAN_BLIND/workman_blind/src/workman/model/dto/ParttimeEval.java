
package workman.model.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "parteval_seq_gen", sequenceName = "parteval_seq_id", initialValue = 1, allocationSize = 50) 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
public class ParttimeEval implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parteval_seq_gen")
	@Column(name = "eval_num")
	private int evalnum;
		
	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	private Member userid; 
	
	@ManyToOne
	@JoinColumn(name = "company_name", nullable=false)
	private Company companyname;
	
	@Column(name = "pros_cons")
	private String proscons;
	
	@Column(name = "wage_delay")
	private String wagedelay;
	
	@Column(name = "environment")
	private String environment;
	
	@Column(name = "incline")
	private String incline;
	
	// 추가 의견
	@Column(name = "opinion")
	private String opinion;
	
}
