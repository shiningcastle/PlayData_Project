package animal.view;

import animal.controller.PrivateInformationController;
import animal.model.dto.Pet;
import animal.model.dto.PrivateInformation;
import animal.model.dto.Protector;

public class StartView {

	public static void main(String[] args) {
		
		PrivateInformationController controller = PrivateInformationController.getInstance();
		
		System.out.println("\n*** 01. 방문한 모든 반려동물 목록 검색 ***");
		controller.getpetList();
		
		System.out.println("\n*** 02. 토토라는 이름의 강아지 검색 ***");
		controller.getInformation("토토");
		
		System.out.println("\n*** 03. 등록되지 않은 반려동물 이름 검색 ***"); // 동물병원 첫 방문
		controller.getInformation("몽이");
		
		System.out.println("\n*** 04. 첫 방문한 반려동물 DB등록 ***");
		PrivateInformation newinformation = new PrivateInformation(new Pet("몽이", "cat","russian blue", "grey", "male", "071013", 13),
				(new Protector("강지혜", 98563723, "제주특별자치도 제주시 애월읍", "몽이")));
		
		System.out.println("\n*** 04-1. 신규등록 전 반려동물 목록 검색 ***");
		controller.getpetList();
	
		controller.insertInformation(newinformation);
		System.out.println("\n*** 04-2. 정상등록 후 반려동물 목록 검색 ***");
		controller.getpetList();
		
		System.out.println("\n*** 05. 자봉의 진료기록 조회 ***"); // 기 방문
		controller.getProtocol("자봉");
		
		System.out.println("\n05-1. 이미 저장된 프로젝트 재저장 시도후 유효성 검증의 적합성 검증");
		controller.insertInformation(newinformation);
		
		System.out.println("\n*** 06. 방문이력이 있는 '몽이' 보호자의 정보 변경 후 수정한 내용 검색 **");
		System.out.println("06-1. 수정 전 프로젝트 검색");
		controller.getInformation("몽이");
		controller.updateInformationPet("몽이", new Protector("조윤혜", 41814875, "서울특별시 광진구", "몽이"));
		System.out.println("06-2. 수정 후  프로젝트 검색");
		controller.getInformation("몽이");
		
		System.out.println("\n*** 07. '몽이' 정보 삭제 후 삭제한 information 검색 ***");
		System.out.println("\n07-1. 삭제 전 프로젝트 검색 ");
		controller.getInformation("몽이");
		controller.deleteInformation("몽이");
		
		System.out.println("\n07-2. 삭제 후 프로젝트 검색 ");
		controller.getInformation("몽이");
		
		System.out.println("\n07-3. 삭제된 프로젝트 삭제 재시도 후 유효성 로직의 적합성 검증");
		controller.deleteInformation("몽이");
		
	}

}
