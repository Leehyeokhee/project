# java_miniproject

간단한 게임을 만들자 - 3인 miniproject

1. 기능
- 플레이어 추가, 삭제 및 종료 시 객체 저장, 시작 시 객체 불러오기
- 게임을 통해 얻는 포인트를 기준으로 한 랭킹시스템
- 게임 시작 전 각 게임마다의 설명을 확인할 수 있는 RuleBook 제공
- 총 3가지 게임 제공
  - 유러피언 룰렛
  - 레인보우 홀덤
  - 행맨

2. 게임 규칙<br/>
2-1 유러피언 룰렛
 - 크게 inside, outside 배팅이 있으며 각각 5가지 총 10가지의 배팅 방법이 존재합니다.
 - inside 배팅은 당첨 확률이 낮은 대신 배당률이 높으며 outside 배팅은 당첨 확률이 높지만 배당률이 낮습니다.<br/>
2-2 레인보우 홀덤<br/>
 - 개인카드 3장, 공유카드 4장의 조합에서 중복되는 수를 제외한 나머지 카드의 합을 계산하여 더 적은 쪽이 승리합니다.
 - 레인보우 : 개인카드와 공유카드 7장의 수가 모두 다르면 레인보우가 되며 승리합니다.
 - 무승부일 시 플레이어의 패배<br/>
2-3 행맨<br/>
 - 영어단어를 맞추는 게임입니다.
 - 총 3개의 카테고리가 있으며 총 7번을 틀리면 패배합니다.
 - 소유한 포인트를 사용해 hint와 undo(되돌리기)를 사용할 수 있습니다.
 
역할 분담
- 각자 게임을 하는 데 필요한 요소를 가지고 만든 후 병합
- 각 게임을 1개씩 맡아서 만들기

기간 3일
- 1일차 : 주제 선정 및 기능 설계, 역할 분담
- 2일차 : 개인별 게임 구현
- 3일차 : 각자 만든 게임 병합

2차 miniproject - oracle과 연동 및 커뮤니티 개설
1. 기능
 - 플레이어와 db 연동 후 회원가입 및 로그인 기능 추가
 - 로그인 후 비밀번호 및 닉네임 변경, 탈퇴 기능 추가
 - 게임 플레이 후 포인트 db와 연결 및 포인트를 기준으로 한 랭킹시스템 추가
 - 커뮤니티 기능 추가
    - 일반 플레이어
      - 글 작성 및 검색, 수정, 삭제 기능 추가
      - 댓글 작성 및 수정, 삭제 기능 추가
    - 관리자
      - 모든 플레이어의 글, 댓글 관리 기능 추가
      - 공지사항 작성 가능
      - 블랙리스트 관리로 부적절한 게시글 올리는 유저의 커뮤니티 사용제한 기능 추가
 - 관리자 회원 관리 기능 추가
    - 부적절한 닉네임의 유저 닉네임 변경 기능 추가
    - 불량 유저 강제 탈퇴 기능 추가
 - 관리자 행맨 단어 관리 기능 추가
    - 행맨 게임의 카테고리 및 단어 추가, 수정, 삭제 기능 추가
2. 역할분담
  - 각자 만든 게임의 포인트 연동 기능 추가 후 병합
  - sqltable 및 players, forum, rep_forum, blacklist 틀은 내가.....

기간 3일
  - 1일차 : db연동에 필요한 sqltable 제작 및 커뮤니티 기능 설계
  - 2일차 : 개인별 포인트 연동 구현 및 커뮤니티 관련 패키지 구현
  - 3일차 : 개인별 포인트 연동 게임의 병합 및 디버깅
