-- company 테이블 기업 저장
<<<<<<< Updated upstream
insert into company values('샹떼pc방인천동춘점','1234','pc방','인천광역시 연수구 동춘동 933-5번지 영창빌딩 5층','010-9280-4437');
insert into company values('cu충정로프랑스점','1234','편의점','부산광역시 금정구 장전2동 금강로279번길 81-14','010-9280-7637');
insert into company values('이마트 천안서북점 이니스프리','1234','화장품가게','대구광역시 중구 서성로 99 104동 상가 141호 대구역센트럴자이','010-9280-7624');
insert into company values('GS25대구역자이점','1234','편의점','대구광역시 중구 서성로 99 104동 상가 141호 대구역센트럴자이','010-8920-8402');
insert into company values('한솥도시락시화점','1234','음식점','경기도 시흥시 정왕동 1742-17','010-9280-7629');
insert into company values('투썸플레이스송도점','1234','카페','인천광역시 연수구 송도1동 컨벤시아대로 69','010-9280-7557');

insert into company values('플레이데이터','1234','교육기관','서울시 서초구 서초대로46길 42, 엔코아 타워','010-9280-7887');
-- member 테이블 회원 저장 -문제
insert into member values('kwon0329','1234','권희성','010-1234-5678','플레이데이터');
insert into member values('jongwook123','1234','장종욱','010-1234-5666','샹떼pc방인천동춘점');
insert into member values('moonyangels2','1234','장문희','010-1234-5632','이마트 천안서북점 이니스프리');
insert into member values('kwon1234','1234','홍길동','010-1234-5633','GS25대구역자이점');
insert into member values('kwon5678','1234','이순신','010-1234-5655','샹떼pc방인천동춘점');
=======
insert into company values('샹떼pc방인천동춘점','restplease01','인천광역시 연수구 동춘동 933-5번지 영창빌딩 5층','010-9280-4437','pc방');
insert into company values('cu충정로프랑스점','restplease00','부산광역시 금정구 장전2동 금강로279번길 81-14','010-9280-7637','편의점');
insert into company values('이마트 천안서북점 이니스프리','restplease02','대구광역시 중구 서성로 99 104동 상가 141호 대구역센트럴자이','010-9280-7624','화장품가게');
insert into company values('GS25대구역자이점','restplease03','대구광역시 중구 서성로 99 104동 상가 141호 대구역센트럴자이','010-8920-8402','편의점');
insert into company values('한솥도시락시화점','restplease04','경기도 시흥시 정왕동 1742-17','010-9280-7629','음식점');
insert into company values('투썸플레이스송도점','restplease05','인천광역시 연수구 송도1동 컨벤시아대로 69','010-9280-7557','카페');

-- member 테이블 회원 저장
insert into member values('kwon0329','restplease00','권희성','010-1234-5678','플레이데이터');
insert into member values('jongwook123','restplease01','장종욱','010-1234-5666','샹떼pc방인천동춘점');
insert into member values('moonyangels2','restplease02','장문희','010-1234-5632','이마트 천안서북점 이니스프리');
insert into member values('kwon1234','restplease03','홍길동','010-1234-5633','GS25대구역자이점');
insert into member values('kwon5678','restplease04','이순신','010-1234-5655','샹떼pc방인천동춘점');


>>>>>>> Stashed changes

-- parttimelist 테이블 알바리스트 저장
insert into parttimelist values(208254,'샹떼pc방인천동춘점','6시간',9000,'1년이상','피씨방 꿀알바 식대무한제공');
insert into parttimelist values(208252,'cu충정로프랑스점','3시간',8590,'6개월이상','편의점 알바 급구합니다');
<<<<<<< Updated upstream
insert into parttimelist values(208255,'이마트 천안서북점 이니스프리','8시간',9000,'6개월이상','화장품 좋아하는분 환영');
insert into parttimelist values(208253,'GS25대구역자이점','5시간',8590,'3개월이상','오전알바 구합니다');
insert into parttimelist values(208258,'한솥도시락시화점','6시간',8590,'6개월이상','식대무료 알바구함');
insert into parttimelist values(208257,'투썸플레이스송도점','5시간',9500,'6개월이상','카페알바 경력구함');
insert into parttimelist values(208256,'플레이데이터','5시간',10000,'1년이상','가족같은 직원 구합니다');

-- parttimeeval 테이블 알바평가게시글 저장-문제
insert into parttimeeval values(208275,'kwon0329','플레이데이터','칼퇴가능','안밀려요','식사제공','깐깐해요','오래오래 일하고 싶어요');
insert into parttimeeval values(208234,'jongwook123','샹떼pc방인천동춘점','칼퇴가능','안밀려요','식사제공','깐깐해요','너무 바빠요');
insert into parttimeeval values(208211,'moonyangels2','이마트 천안서북점 이니스프리','칼퇴가능','안밀려요','식사제공','깐깐해요','단기로 할거면 추천');
insert into parttimeeval values(208287,'kwon1234','GS25대구역자이점','칼퇴가능','안밀려요','식사제공','깐깐해요','진상손님이 많아요');
=======



CREATE TABLE parttimelist (
       text_list             NUMBER(10) PRIMARY KEY,
       company_name          VARCHAR2(50) NOT NULL,
       user_id              VARCHAR2(50) NOT NULL,
       review_num          NUMBER(10) NOT NULL,
       review_score          NUMBER(10) NOT NULL,
       recruit_status        VARCHAR2(50) NOT NULL,
       regist_date          VARCHAR2(50) NOT NULL,
       emp_period          VARCHAR2(50) NOT NULL
);


-- parttimeeval 테이블 알바평가게시글 저장
insert into parttimeeval values(208252,'kwon0329','칼퇴가능','안밀려요','식사제공','깐깐해요','손님이많아요','경험1');
>>>>>>> Stashed changes


commit;