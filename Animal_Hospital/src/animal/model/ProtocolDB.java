package animal.model;

import java.util.ArrayList;

import animal.model.dto.Protocol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ProtocolDB {
	
	private static ProtocolDB instance = new ProtocolDB();
	private ArrayList<Protocol> protocolList = new ArrayList<>();
	
	private ProtocolDB() {
		protocolList.add(new Protocol(200707, "토토", "Luxating patella", "claudication", "pain killer"));
		protocolList.add(new Protocol(200709, "자봉", "Dirofilaria immitis", "cough", "Heartgard Plus"));
		protocolList.add(new Protocol(200713, "임금", "Canine distemper", "Vaccination", "pain killer"));
		protocolList.add(new Protocol(200722, "리온", "Luxating patella", "claudication", "pain killer"));
		protocolList.add(new Protocol(200805, "토토","Luxating patella", "claudication", "pain killer"));
		protocolList.add(new Protocol(200810, "자봉","Luxating patella", "claudication", "pain killer"));
		protocolList.add(new Protocol(200812, "자봉","Luxating patella", "claudication", "pain killer"));
	}
	public static ProtocolDB getInstance() {
		return instance;
	}
	
	public void insertProtocol(Protocol newProtocol) {
		protocolList.add(newProtocol);
	}
}
