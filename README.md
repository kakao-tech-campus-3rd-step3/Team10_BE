# 이게머니 – 쉽고 정확하게, 나만의 경제 교과서

<p align="center">
  <img src="./imgs/logo.svg" alt="[이게머니]" width="150">
</p>


## 서비스 배경
- 최근 사회 초년생과 청년층 사이에서 금융 문맹(금융지식 부족) 문제가 심화되고 있습니다.
- 금융 지식이 부족한 상태에서 대출, 투자, 소비를 시작하면서 실제로 피해를 입는 사례가 점점 늘어나고 있습니다.
- 잘못된 금융 판단은 과소비, 부채 누적, 금융사기 피해 등으로 이어질 수 있습니다.
- 하지만 정규 교육과정에서는 실질적인 금융 교육의 기회가 여전히 부족하며, 제공되는 일부 프로그램도 이론 위주라 흥미와 접근성이 낮은 한계가 존재합니다.

## 소개

금융 교육을 위한 게이미피케이션 웹 애플리케이션입니다. 사용자는 퀴즈 풀기, 투자 성향 테스트, 금융 콘텐츠 탐색, 랭킹 시스템, 출석 체크 등을 통해 금융 지식을 습득할 수 있습니다.
- 퀴즈를 풀며 캐릭터 '콩식이'를 성장시키고 꾸미는 과정에서 느끼는 학습의 재미와 성취감 제공
- 에빙하우스 망각 곡선 기반 오답 문제 복습 시스템, 북마크, 오답 노트 등의 기능을 통한 체계적이고 효율적인 학습
- 초보자도 입문하기 쉬운 '경제 기초'와, 주식 시장, 글로벌 경제, 생활 경제, 부동산 등 실생활에 도움이 되는 유용한 개념을 다루는 문항들로 퀴즈 구성
- 자투리 시간에도 부담 없이 학습이 가능하도록 간단한 구조로 설계
- 중·고등학생은 등·하교 시간 등 일상 속에서 금융 기초를 쉽게!
- 사회 초년생과 직장인도 출퇴근 시간 등 짧은 틈을 활용해 실질적인 금융 지식을 쉽게!
- 금융 콘텐츠 탭을 통해 사용자에게 도움이 될 금융 관련 정보, 정책, 상품 등을 쉽게 찾아볼 수 있도록 설계
- 이를 통해 금융 교육의 접근성을 높이고, 재미있는 학습 경험을 제공합니다



## 주요 기능

<table>
  <tr>
    <td align="center" width="50%">
      <b>퀴즈 풀이 및 해설</b><br/>
      - 4개 카테고리 별 퀴즈 제공<br/>
      - 4지선다, O/X, 주관식 유형 제공<br/><br/>
      <img width="350" alt="퀴즈 풀이 및 해설"
           src="./imgs/QUIZ.gif">
    </td>
    <td align="center" width="50%">
      <b>오답 날짜 기반 자동 복습</b><br/>
      - 오답 문제 자동 복습 시스템<br/>
      - 학습 전 1일/4일 전 틀린 문제 제공<br/><br/>
      <img width="350" alt="오답 날짜 기반 자동 복습"
           src="./imgs/Review.gif">
    </td>
  </tr>

  <tr>
    <td align="center" width="50%">
      <b>출석 기능</b><br/>
      - 5문제 풀이 시 일일 출석 기록<br/>
      - 연속 출석 랭킹으로 꾸준한 학습 동기 고취<br/><br/>
      <img width="350" alt="출석 기능"
           src="./imgs/Attendence.gif">
    </td>
    <td align="center" width="50%">
      <b>랭킹 및 티어 시스템</b><br/>
      - 레이팅 기반 티어 제공<br/>
      - 누적 퀴즈 풀이, 연속 출석일별 랭킹 순위 제공<br/><br/>
      <img width="350" alt="랭킹 및 티어 시스템"
           src="./imgs/Ranking.png">
    </td>
  </tr>

  <tr>
    <td align="center" width="50%">
      <b>코스튬 기능</b><br/>
      - 나만의 메인 캐릭터 '콩식이' 꾸미기<br/>
      - 추후 퀴즈 풀이로 얻는 코인 도입해 기능 강화 예정<br/><br/>
      <img width="350" alt="코스튬 기능"
           src="./imgs/Costume.gif">
    </td>
    <td align="center" width="50%">
      <b>금융 컨텐츠</b><br/>
      - 다양한 금융 상품 소개<br/>
      - 사람들이 놓칠 수 있는 실생활 금융 정보 제공<br/><br/>
      <img width="350" alt="금융 컨텐츠"
           src="./imgs/Contents.gif">
    </td>
  </tr>

  <tr>
    <td align="center" width="50%">
      <b>투자 성향 진단 기능</b><br/>
      - 자가 체크리스트를 통한 내 투자 성향 진단<br/>
      - 5가지 투자 성향 제공<br/><br/>
      <img width="350" alt="투자 성향 테스트"
           src="./imgs/Test.gif">
    </td>
    <td align="center" width="50%">
      <b>성향 및 티어 공유 기능</b><br/>
      - 나의 투자 성향 테스트 결과 및 내 티어 이미지 공유 기능<br/><br/>
      <img width="350" alt="공유 기능"
           src="./imgs/Share.png">
    </td>
  </tr>
</table>



# 기술스택
Spring | MySQL | JPA | Docker | AWS | Nginx
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
<img src="https://img.icons8.com/?size=100&id=90519&format=png&color=000000" width="80"/> | <img src="https://img.icons8.com/?size=100&id=QeIg9siFKGgp&format=png&color=000000" width="80"/> | <img src="./imgs/jpa_icon.svg" width="80"/> | <img src="https://img.icons8.com/?size=100&id=22813&format=png&color=000000" width="80"/> | <img src="https://img.icons8.com/?size=100&id=33039&format=png&color=000000" width="80"/> | <img src="https://img.icons8.com/?size=100&id=f8puwbhs0kUR&format=png&color=000000" width="80"/>



# 아키텍쳐
<img src="./imgs/archi.png" >


# ERD
<img src="./imgs/erd.png" width=80%>

# API 
<img width="728" height="558" alt="image" src="https://github.com/user-attachments/assets/37d68889-4335-40af-a510-6bc18dd8c14b" />
<img width="728" height="453" alt="image" src="https://github.com/user-attachments/assets/e09605ae-508d-4f9d-9645-13fe48eaea79" />




# 이게머니 BE 팀 구성원

|[박재일](https://github.com/JAEIL1999)|[이시웅](https://github.com/silverttthin)|[배근호](https://github.com/hopencode)|[권윤재](https://github.com/36yi)|
|:--:|:--:|:--:|:--:|
|<img src="https://github.com/JAEIL1999.png" alt="박재일" width="100" height="100">|<img src="https://github.com/silverttthin.png" alt="이시웅" width="100" height="100">|<img src="https://github.com/hopencode.png" alt="배근호" width="100" height="100">|<img src="https://github.com/36yi.png" alt="권윤재" width="100" height="100">|
|BE|BE|BE|BE|
|조장|BE 테크리더|메이커|메이커|
