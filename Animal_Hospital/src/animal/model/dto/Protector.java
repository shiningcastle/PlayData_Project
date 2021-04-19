package animal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Protector {
	
	private String name;
	private int phoneNumber;
	private String address;
	private String petName;
	
	@Override
	public String toString() {
		StringBuilder protectorBuilder = new StringBuilder();
		protectorBuilder.append(" ��ȣ�� ���� : ");
		protectorBuilder.append(name);
		protectorBuilder.append(", �޴���ȭ : ");
		protectorBuilder.append(phoneNumber);
		protectorBuilder.append(", �ּ� : ");
		protectorBuilder.append(address);
		protectorBuilder.append(", �ݷ����� �̸� : ");
		protectorBuilder.append(petName);
		return protectorBuilder.toString();
	}
}
