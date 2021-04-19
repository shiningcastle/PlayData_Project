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

	private int date;			// ��������
	private String petName; 	// �ݷ����� �̸� 
	private String diseases;	// ����
	private String symptom;		// ����
	private String prescription;// ó��
	
	@Override
	public String toString() {
		StringBuilder protocolBuilder = new StringBuilder();
		protocolBuilder.append(" �������� : ");
		protocolBuilder.append(date);
		protocolBuilder.append(", �ݷ����� �̸� : ");
		protocolBuilder.append(petName);
		protocolBuilder.append(", ���ܸ� : ");
		protocolBuilder.append(diseases);
		protocolBuilder.append(", ���� : ");
		protocolBuilder.append(symptom);
		protocolBuilder.append(", ó�� : ");
		protocolBuilder.append(prescription);
		return protocolBuilder.toString();
	}
}
