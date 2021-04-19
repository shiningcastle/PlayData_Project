package model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@SequenceGenerator(name = "con_seq_gen", sequenceName = "con_seq_id", initialValue = 1, allocationSize = 50)

@Entity
public class Connection {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "con_seq_gen")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cos_id")
	private Cosmetics cos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "com_id")
	private Component com;

}
