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
		protectorBuilder.append(" 보호자 성명 : ");
		protectorBuilder.append(name);
		protectorBuilder.append(", 휴대전화 : ");
		protectorBuilder.append(phoneNumber);
		protectorBuilder.append(", 주소 : ");
		protectorBuilder.append(address);
		protectorBuilder.append(", 반려동물 이름 : ");
		protectorBuilder.append(petName);
		return protectorBuilder.toString();
	}
}
