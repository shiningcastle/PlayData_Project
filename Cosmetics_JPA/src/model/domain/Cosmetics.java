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

@SequenceGenerator(name = "cos_seq_gen", sequenceName = "cos_seq_id", initialValue = 1, allocationSize = 50)

@Entity

public class Cosmetics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cos_seq_gen")
	@Column(name="cos_id")
	private int cosid;
	
	@Column(name="cos_name")
	private String cosname;

	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private int price;
	
	@Column(name = "capacity")
	private String capacity;
	
	@OneToMany(mappedBy = "cos")
	private List<Connection> con; 	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cosmetics [cosid=");
		builder.append(cosid);
		builder.append(", cosname=");
		builder.append(cosname);
		builder.append(", category=");
		builder.append(category);
		builder.append(", price=");
		builder.append(price);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append("]");
		return builder.toString();
	}
}
