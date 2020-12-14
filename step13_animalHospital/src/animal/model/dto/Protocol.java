package animal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Protocol {

	private int date;			// 진료일자
	private String petName; 	// 반려동물 이름 
	private String diseases;	// 병명
	private String symptom;		// 증상
	private String prescription;// 처방
	
	@Override
	public String toString() {
		StringBuilder protocolBuilder = new StringBuilder();
		protocolBuilder.append(" 진료일자 : ");
		protocolBuilder.append(date);
		protocolBuilder.append(", 반려동물 이름 : ");
		protocolBuilder.append(petName);
		protocolBuilder.append(", 진단명 : ");
		protocolBuilder.append(diseases);
		protocolBuilder.append(", 증상 : ");
		protocolBuilder.append(symptom);
		protocolBuilder.append(", 처방 : ");
		protocolBuilder.append(prescription);
		return protocolBuilder.toString();
	}
}
