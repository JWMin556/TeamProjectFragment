package com.example.teamprojectfragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamprojectfragment.repository.ProblemsRepository
//각 주제에 따라 모든 퀴즈의 문제, 정답, 4지선 다항들을 map으로 묶은뒤, 그 녀석들을 한꺼번에 array에 넣어줬습니다.
val problems1 = arrayOf( //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
    mapOf("question" to "그 아이는 좀 (    )이다.",
        "answer" to "안하무인",
        "example1" to "안아무인",
        "example2" to "아나무인",
        "example3" to "안하무인",
        "example4" to "안놔무인"),
    mapOf("question" to "이 음식은 맛이 (    ).",
        "answer" to "무난하다",
        "example1" to "무나하다",
        "example2" to "문안하다",
        "example3" to "무낭하다",
        "example4" to "무난하다"),
    mapOf("question" to "내 별명은 (    )이다.",
        "answer" to "개구쟁이",
        "example1" to "개구쟁이",
        "example2" to "게구쟁이",
        "example3" to "개구장이",
        "example4" to "게구장이"),
    mapOf("question" to "(    )로 일찍 일어났어?",
        "answer" to "웬일",
        "example1" to "웬일",
        "example2" to "웬닐",
        "example3" to "왠닐",
        "example4" to "왠일"),
    mapOf("question" to "(    )에게 인사를 잘합시다.",
        "answer" to "웃어른",
        "example1" to "위어른",
        "example2" to "욷어른",
        "example3" to "윗어른",
        "example4" to "웃어른"),
    mapOf("question" to "(    ) 놀이동산에 놀러갔습니다.",
        "answer" to "오랜만에",
        "example1" to "오랫만에",
        "example2" to "오래만에",
        "example3" to "오랜만에",
        "example4" to "오랭만에"),
    mapOf("question" to "생각을 (    ) 해봅시다.",
        "answer" to "곰곰이",
        "example1" to "공공이",
        "example2" to "곰곰히",
        "example3" to "곰고미",
        "example4" to "곰곰이"),
    mapOf("question" to "감기에 걸렸다가 다 (    ).",
        "answer" to "나았다",
        "example1" to "나았다",
        "example2" to "낳았다",
        "example3" to "나왔다",
        "example4" to "낳왔다"),
    mapOf("question" to "(    ) 같이 집에 가자.",
        "answer" to "이따가",
        "example1" to "읻다가",
        "example2" to "이따가",
        "example3" to "있다가",
        "example4" to "있따가"),
    mapOf("question" to "너무 황당하고 (    )",
        "answer" to "어이없다",
        "example1" to "어의없다",
        "example2" to "어의업다",
        "example3" to "어이없다",
        "example4" to "어이업다"),

    mapOf("question" to "손을 (    ) 씻어야합니다.",
        "answer" to "깨끗이",
        "example1" to "깨끄시",
        "example2" to "깨끗히",
        "example3" to "깨끗이",
        "example4" to "깨끄치"),
    mapOf("question" to "토끼가 귀를 (    ) 세운다.",
        "answer" to "쫑긋쫑긋",
        "example1" to "쫀끗쫀끗",
        "example2" to "쫑끗쫑끗",
        "example3" to "쫀긋쫀긋",
        "example4" to "쫑긋쫑긋"),
    mapOf("question" to "세수를 해서 (    )을 떼야지.",
        "answer" to "눈곱",
        "example1" to "눙꼽",
        "example2" to "눈꼽",
        "example3" to "눙곱",
        "example4" to "눈곱"),
    mapOf("question" to "힘찬 발걸음을 (    ).",
        "answer" to "내디디다",
        "example1" to "내딛이다",
        "example2" to "내디디다",
        "example3" to "내딪이다",
        "example4" to "내디지다"),
    mapOf("question" to "안전한 (    )",
        "answer" to "학굣길",
        "example1" to "학굗길",
        "example2" to "하꾜길",
        "example3" to "학굣길",
        "example4" to "하교길"),
    mapOf("question" to "개미와 (    )",
        "answer" to "베짱이",
        "example1" to "베짱이",
        "example2" to "배짱이",
        "example3" to "벳짱이",
        "example4" to "뱃장이"),
    mapOf("question" to "예쁜 스티커가 (    ) 벽지",
        "answer" to "붙여진",
        "example1" to "붙혀진",
        "example2" to "붙여진",
        "example3" to "부텨진",
        "example4" to "부처진"),
    mapOf("question" to "(    ) 내 동생",
        "answer" to "예쁜",
        "example1" to "얘쁜",
        "example2" to "에쁜",
        "example3" to "이쁜",
        "example4" to "예쁜"),
    mapOf("question" to "맛있는 (    )",
        "answer" to "김치찌개",
        "example1" to "김치찌개",
        "example2" to "김치찌계",
        "example3" to "김치찌게",
        "example4" to "김치찌걔"),
    mapOf("question" to "거기 (    ) 서서 뭐해?",
        "answer" to "가만히",
        "example1" to "가망이",
        "example2" to "가만히",
        "example3" to "가마니",
        "example4" to "가만이")
)

val problems2 = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
    mapOf("question" to "1 + 2 = ?",
        "answer" to "3",
        "example1" to "1",
        "example2" to "3",
        "example3" to "2",
        "example4" to "4"),
    mapOf("question" to "3 x 2 = ?",
        "answer" to "6",
        "example1" to "4",
        "example2" to "6",
        "example3" to "5",
        "example4" to "2"),
    mapOf("question" to "5 - 3 = ?",
        "answer" to "2",
        "example1" to "6",
        "example2" to "1",
        "example3" to "5",
        "example4" to "2"),
    mapOf("question" to "8 ÷ 4 = ?",
        "answer" to "2",
        "example1" to "1",
        "example2" to "2",
        "example3" to "4",
        "example4" to "3"),
    mapOf("question" to "4 + 2 = ?",
        "answer" to "6",
        "example1" to "6",
        "example2" to "4",
        "example3" to "2",
        "example4" to "5"),
    mapOf("question" to "5 - 4 = ?",
        "answer" to "1",
        "example1" to "3",
        "example2" to "6",
        "example3" to "7",
        "example4" to "1"),
    mapOf("question" to "4 x 3 = ?",
        "answer" to "12",
        "example1" to "7",
        "example2" to "12",
        "example3" to "8",
        "example4" to "3"),
    mapOf("question" to "9 ÷ 3 = ?",
        "answer" to "3",
        "example1" to "7",
        "example2" to "3",
        "example3" to "5",
        "example4" to "4"),
    mapOf("question" to "1 + 4 = ?",
        "answer" to "5",
        "example1" to "4",
        "example2" to "5",
        "example3" to "0",
        "example4" to "6"),
    mapOf("question" to "3 + 1 = ?",
        "answer" to "4",
        "example1" to "8",
        "example2" to "3",
        "example3" to "4",
        "example4" to "0"),
    mapOf("question" to "5 x 5 = ?",
        "answer" to "25",
        "example1" to "23",
        "example2" to "25",
        "example3" to "27",
        "example4" to "29"),
    mapOf("question" to "6 x 8 = ?",
        "answer" to "48",
        "example1" to "48",
        "example2" to "50",
        "example3" to "52",
        "example4" to "54"),
    mapOf("question" to "9 ÷ 3 = ?",
        "answer" to "3",
        "example1" to "1",
        "example2" to "2",
        "example3" to "3",
        "example4" to "4"),
    mapOf("question" to "8 ÷ 4 = ?",
        "answer" to "2",
        "example1" to "2",
        "example2" to "4",
        "example3" to "6",
        "example4" to "8"),
    mapOf("question" to "4 x 2 = ?",
        "answer" to "8",
        "example1" to "3",
        "example2" to "4",
        "example3" to "8",
        "example4" to "11"),
    mapOf("question" to "5 x 4 = ?",
        "answer" to "20",
        "example1" to "16",
        "example2" to "18",
        "example3" to "20",
        "example4" to "22"),
    mapOf("question" to "4 + 3 = ?",
        "answer" to "7",
        "example1" to "7",
        "example2" to "12",
        "example3" to "8",
        "example4" to "3"),
    mapOf("question" to "9 x 3 = ?",
        "answer" to "27",
        "example1" to "27",
        "example2" to "30",
        "example3" to "33",
        "example4" to "36"),
    mapOf("question" to "15 ÷ 3 = ?",
        "answer" to "5",
        "example1" to "4",
        "example2" to "5",
        "example3" to "0",
        "example4" to "6"),
    mapOf("question" to "9 x 7 = ?",
        "answer" to "63",
        "example1" to "61",
        "example2" to "63",
        "example3" to "65",
        "example4" to "67")
)

val problems3 = arrayOf( //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
    mapOf("question" to "스웨덴의 수도는?",
        "answer" to "스톡홀름",
        "example1" to "함마르비",
        "example2" to "스톡홀름",
        "example3" to "코펜하겐",
        "example4" to "헬싱키"),
    mapOf("question" to "말레이시아의 수도는?",
        "answer" to "쿠알라룸푸르",
        "example1" to "쿠알라룸푸르",
        "example2" to "마닐라",
        "example3" to "코타키나발루",
        "example4" to "자카르타"),
    mapOf("question" to "독일의 수도는??",
        "answer" to "베를린",
        "example1" to "뮌헨",
        "example2" to "프랑크푸르트",
        "example3" to "베를린",
        "example4" to "잘츠부르크"),
    mapOf("question" to "중국의 수도는?",
        "answer" to "베이징",
        "example1" to "상하이",
        "example2" to "타이베이",
        "example3" to "베이징",
        "example4" to "칭타오"),
    mapOf("question" to "가나의 수도는?",
        "answer" to "아크라",
        "example1" to "쿠마시",
        "example2" to "타말",
        "example3" to "로메",
        "example4" to "아크라"),
    mapOf("question" to "프랑스의 수도는?",
        "answer" to "파리",
        "example1" to "파리",
        "example2" to "니스",
        "example3" to "리옹",
        "example4" to "브뤼셀"),
    mapOf("question" to "스페인의 수도는?",
        "answer" to "마드리드",
        "example1" to "바르셀로나",
        "example2" to "마드리드",
        "example3" to "그라나다",
        "example4" to "리스본"),
    mapOf("question" to "헝가리의 수도는?",
        "answer" to "부다페스트",
        "example1" to "부쿠레슈티",
        "example2" to "부다페스트",
        "example3" to "리스본",
        "example4" to "자그레브"),
    mapOf("question" to "룩셈부르크의 수도는?",
        "answer" to "룩셈부르크",
        "example1" to "릴",
        "example2" to "룩셈부르크",
        "example3" to "크노케",
        "example4" to "퀼른"),
    mapOf("question" to "불가리아의 수도는?",
        "answer" to "소피아",
        "example1" to "베오그라드",
        "example2" to "소피아",
        "example3" to "부큐레슈티",
        "example4" to "바르나"),
    mapOf("question" to "멕시코의 수도는?",
        "answer" to "멕시코시티",
        "example1" to "칸쿤",
        "example2" to "멕시코시티",
        "example3" to "리마",
        "example4" to "벨모판"),
    mapOf("question" to "베네수엘라의 수도는?",
        "answer" to "카라카스",
        "example1" to "보고타",
        "example2" to "로조우",
        "example3" to "카라카스",
        "example4" to "죠지타운"),
    mapOf("question" to "쿠바의 수도는?",
        "answer" to "하바나",
        "example1" to "포르토프랭스",
        "example2" to "킹스턴",
        "example3" to "낫소",
        "example4" to "하바나"),
    mapOf("question" to "영국의 수도는?",
        "answer" to "런던",
        "example1" to "웰링턴",
        "example2" to "더블린",
        "example3" to "런던",
        "example4" to "맨체스터"),
    mapOf("question" to "러시아의 수도는?",
        "answer" to "모스크바",
        "example1" to "블라디보스톡",
        "example2" to "모스크바",
        "example3" to "상트페테르부르크",
        "example4" to "아스타나"),
    mapOf("question" to "베트남의 수도는?",
        "answer" to "하노이",
        "example1" to "말레",
        "example2" to "하노이",
        "example3" to "팀푸",
        "example4" to "네피도"),
    mapOf("question" to "몽골의 수도는?",
        "answer" to "울란바토르",
        "example1" to "울란바토르",
        "example2" to "바쿠",
        "example3" to "무스카트",
        "example4" to "사나"),
    mapOf("question" to "싱가포르의 수도는?",
        "answer" to "싱가포르",
        "example1" to "테헤란",
        "example2" to "싱가포르",
        "example3" to "자카르타",
        "example4" to "트빌리시"),
    mapOf("question" to "대한민국의 수도는?",
        "answer" to "서울",
        "example1" to "부산",
        "example2" to "평양",
        "example3" to "도쿄",
        "example4" to "서울"),
    mapOf("question" to "네팔의 수도는?",
        "answer" to "카트만두",
        "example1" to "리야드",
        "example2" to "자카르타",
        "example3" to "카트만두",
        "example4" to "예루살렘")
)

val problems4 = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
    mapOf("question" to "(    ) 목에 방울 달기",
        "answer" to "고양이",
        "example1" to "개",
        "example2" to "고양이",
        "example3" to "토끼",
        "example4" to "사자"),
    mapOf("question" to "까마귀 날자 (    ) 떨어진다",
        "answer" to "배",
        "example1" to "배",
        "example2" to "사과",
        "example3" to "복숭아",
        "example4" to "감"),
    mapOf("question" to "달면 삼키고 (    ) 뱉는다",
        "answer" to "쓰면",
        "example1" to "짜면",
        "example2" to "시면",
        "example3" to "상하면",
        "example4" to "쓰면"),
    mapOf("question" to "등잔 (    ) 어둡다",
        "answer" to "밑이",
        "example1" to "밑이",
        "example2" to "위가",
        "example3" to "오른쪽이",
        "example4" to "왼쪽이"),
    mapOf("question" to "말이 (    ) 된다",
        "answer" to "씨가",
        "example1" to "씨가",
        "example2" to "뿌리가",
        "example3" to "거짓말이",
        "example4" to "안"),
    mapOf("question" to "미운 아이 (    ) 하나 더 준다",
        "answer" to "떡",
        "example1" to "사탕",
        "example2" to "곶감",
        "example3" to "떡",
        "example4" to "초콜릿"),
    mapOf("question" to "바늘 도둑이 (    ) 된다",
        "answer" to "소도둑",
        "example1" to "부자",
        "example2" to "소도둑",
        "example3" to "거지",
        "example4" to "실도둑"),
    mapOf("question" to "사공이 많으면 배가 (    ) 간다",
        "answer" to "산으로",
        "example1" to "사막으로",
        "example2" to "들로",
        "example3" to "바다로",
        "example4" to "산으로"),
    mapOf("question" to "(    )도 밟으면 꿈틀한다",
        "answer" to "지렁이",
        "example1" to "개미",
        "example2" to "거미",
        "example3" to "꿀벌",
        "example4" to "지렁이"),
    mapOf("question" to "(    )도 제 말하면 온다",
        "answer" to "호랑이",
        "example1" to "호랑이",
        "example2" to "사람",
        "example3" to "앵무새",
        "example4" to "코끼리"),

    mapOf("question" to "(    )도 약에 쓰려면 없다",
        "answer" to "개똥",
        "example1" to "꽃",
        "example2" to "음식",
        "example3" to "개똥",
        "example4" to "떡"),
    mapOf("question" to "닭 잡아먹고 (    ) 내민다",
        "answer" to "오리발",
        "example1" to "오리발",
        "example2" to "닭발",
        "example3" to "오리머리",
        "example4" to "닭머리"),
    mapOf("question" to "도둑이 (    ) 저리다",
        "answer" to "제 발",
        "example1" to "제 발",
        "example2" to "제 손",
        "example3" to "뼈가",
        "example4" to "가슴이"),
    mapOf("question" to "(    ) 겉 핥기",
        "answer" to "수박",
        "example1" to "콩",
        "example2" to "수박",
        "example3" to "사과",
        "example4" to "레몬"),
    mapOf("question" to "우물 안 (    )",
        "answer" to "개구리",
        "example1" to "물",
        "example2" to "개구리",
        "example3" to "물",
        "example4" to "물고기"),
    mapOf("question" to "(    )가 방앗간을 그냥 지나치랴",
        "answer" to "참새",
        "example1" to "앵무새",
        "example2" to "참새",
        "example3" to "독수리",
        "example4" to "비둘기"),
    mapOf("question" to "자라 보고 놀란 가슴 (    ) 보고 놀란다",
        "answer" to "솥뚜껑",
        "example1" to "낫",
        "example2" to "바늘",
        "example3" to "도끼",
        "example4" to "솥뚜껑"),
    mapOf("question" to "목마른 사람이 (    ) 판다",
        "answer" to "우물",
        "example1" to "생수",
        "example2" to "우물",
        "example3" to "음료수",
        "example4" to "시냇물"),
    mapOf("question" to "(    )도 나무에서 떨어진다",
        "answer" to "원숭이",
        "example1" to "참새",
        "example2" to "원숭이",
        "example3" to "나무늘보",
        "example4" to "개"),
    mapOf("question" to "(    )이 넝쿨째로 굴러 들어온다",
        "answer" to "호박",
        "example1" to "나뭇잎",
        "example2" to "꽃",
        "example3" to "수박",
        "example4" to "호박")
)

val problems5 = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
    mapOf("question" to "우리 나라 최초의 국가는?",
        "answer" to "고조선",
        "example1" to "백제",
        "example2" to "고구려",
        "example3" to "신라",
        "example4" to "고조선"),
    mapOf("question" to "‘널리 인간을 이롭게 한다.’는 고조선의 건국 이념은?",
        "answer" to "홍익인간",
        "example1" to "자비",
        "example2" to "홍익인간",
        "example3" to "사랑",
        "example4" to "배고파요"),
    mapOf("question" to "동명 성왕인 주몽이 세운 나라의 이름은?",
        "answer" to "고구려",
        "example1" to "고구려",
        "example2" to "조선",
        "example3" to "고려",
        "example4" to "태봉"),
    mapOf("question" to "100만이 넘는 수나라의 대군을 살수의 얕은 물로 유인하여 거의 전멸시킨 사람은 누구인가?",
        "answer" to "을지문덕",
        "example1" to "주몽",
        "example2" to "이순신",
        "example3" to "을지문덕",
        "example4" to "궁예"),
    mapOf("question" to "일본이 1592년에 조선을 침략하였는데 이 전쟁을 무엇이라고 하는가?",
        "answer" to "임진왜란",
        "example1" to "임진왜란",
        "example2" to "병자호란",
        "example3" to "적벽대전",
        "example4" to "정묘호란"),
    mapOf("question" to "이순신 장군이 적선을 한산도 앞 넓은 바다로 유인하여 학익진 전법으로 크게 무찔러 승리한 싸움은?",
        "answer" to "한산도대첩",
        "example1" to "명량해전",
        "example2" to "노량해전",
        "example3" to "한산도대첩",
        "example4" to "옥포해전"),
    mapOf("question" to "태조 왕건이 세운 나라는?",
        "answer" to "고려",
        "example1" to "마진",
        "example2" to "고려",
        "example3" to "신라",
        "example4" to "동예"),
    mapOf("question" to "훈민정음으로 쓴 최초의 글로 왕실 조상의 역사를 노래한 것은 무엇인가?",
        "answer" to "용비어천가",
        "example1" to "세설실어",
        "example2" to "용비어천가",
        "example3" to "아리랑",
        "example4" to "피리부는 사나이"),
    mapOf("question" to "신사임당의 아들이며 조선 시대의 대표적인 유학자로 10만 양병설을 주장한 사람은 누구인가?",
        "answer" to "이이",
        "example1" to "이황",
        "example2" to "이도",
        "example3" to "정은",
        "example4" to "이이"),
    mapOf("question" to "조선 시대 일본으로 보내던 사신으로 오늘날의 외교 사절에 해당하는 것은?",
        "answer" to "통신사",
        "example1" to "사자",
        "example2" to "해신사",
        "example3" to "통신사",
        "example4" to "연행사"),
    mapOf("question" to " 왕의 친척이나 신하가 강력한 권력을 잡고 온갖 결정을 마음대로 하는 정치 형태를 뭐라고 하나?",
        "answer" to "세도정치",
        "example1" to "탁고",
        "example2" to "세도정치",
        "example3" to "재상정치",
        "example4" to "영의정"),
    mapOf("question" to "기원전 18년 고구려에서 내려온 유이민들이 한강 근처의 위례성에 자리 잡고 세운 나라는?",
        "answer" to "백제",
        "example1" to "백제",
        "example2" to "조선",
        "example3" to "고려",
        "example4" to "옥저"),
    mapOf("question" to "출신 성분에 따라 골과 품으로 등급을 나누는 신라의 신분제도는?",
        "answer" to "골품제",
        "example1" to "과거제",
        "example2" to "연좌제",
        "example3" to "사형제",
        "example4" to "골품제"),
    mapOf("question" to "신라 제27대 왕으로 진평왕의 뒤를 이은 신라 최초의 여왕은?",
        "answer" to "선덕여왕",
        "example1" to "진성여왕",
        "example2" to "장희빈",
        "example3" to "선덕여왕",
        "example4" to "진덕여왕"),
    mapOf("question" to "태조의 셋째 아들로 노비안검법을 제정하고, 958년에 쌍기의 건의에 따라 과거 제도를 실시한 고려 제4대왕은?",
        "answer" to "광종",
        "example1" to "광종",
        "example2" to "명종",
        "example3" to "세종",
        "example4" to "세조"),
    mapOf("question" to "삼국시대에 낙동강 하류의 변한 땅에서 여러 작은 나라들이 모여 연맹체를 이룬 나라는?",
        "answer" to "가야",
        "example1" to "옥저",
        "example2" to "가야",
        "example3" to "동예",
        "example4" to "부여"),
    mapOf("question" to "우리 역사상 가장 넓은 영토를 개척했으며, 해동성국이라 불렸던 나라는?",
        "answer" to "발해",
        "example1" to "발해",
        "example2" to "고구려",
        "example3" to "태봉",
        "example4" to "신라"),
    mapOf("question" to "조선시대 왕들의 재위기간 동안 일어난 일을 편년체 (연대순으로 기록한 역사 서술 방식)로 기록한 역사서는?",
        "answer" to "조선왕조실록",
        "example1" to "징비록",
        "example2" to "조선왕조실록",
        "example3" to "삼국사기",
        "example4" to "직지심체요절"),
    mapOf("question" to "신사임당의 아들이며 조선 시대의 대표적인 유학자로 10만 양병설을 주장한 사람은 누구인가?",
        "answer" to "이이",
        "example1" to "이황",
        "example2" to "이도",
        "example3" to "정은",
        "example4" to "이이"),
    mapOf("question" to "조선시대의 나라를 다스리는 기준이 된 최고의 법전은?",
        "answer" to "경국대전",
        "example1" to "팔만대장경",
        "example2" to "경국대전",
        "example3" to "동학",
        "example4" to "성리학")
)

const val UNCHECKED_POINT = 0
class ProblemsViewModel: ViewModel() {
    //밖에서 함부로 퀴즈데이터를 참고할 수 없도록 private으로 구현하고
    private val _problems1 = MutableLiveData<Array<Map<String, String>>>(problems1)
    private val _problems2 = MutableLiveData<Array<Map<String, String>>>(problems2)
    private val _problems3 = MutableLiveData<Array<Map<String, String>>>(problems3)
    private val _problems4 = MutableLiveData<Array<Map<String, String>>>(problems4)
    private val _problems5 = MutableLiveData<Array<Map<String, String>>>(problems5)

    //밖에서 퀴즈데이터를 쓸 수 있도록 get함수를 사용
    val problemsOfLanguage: LiveData<Array<Map<String, String>>> get() =_problems1
    val problemsOfMath: LiveData<Array<Map<String, String>>> get() = _problems2
    val problemsOfCapital: LiveData<Array<Map<String, String>>> get() = _problems3
    val problemsOfProverb: LiveData<Array<Map<String, String>>> get() = _problems4
    val problemsOfHistory: LiveData<Array<Map<String, String>>> get() = _problems5

    //점수수정을 위한 viewModel
    private val _point = MutableLiveData<Int>(UNCHECKED_POINT)  //밖에서 함수로 점수를 참고할 수 없도록
    val point: LiveData<Int> get() = _point  //밖에서 점수를 볼 수 있도록

    private val repository = ProblemsRepository()
    init {
        repository.observeProblems(_point)
    }

    //교수님의 실습방법을 적용해서 점수를 갱신할때, 밖에서 내부를 함부로 수정할 수 없도록 이중으로 만듭니다.
    private fun modifyPoint(newValue: Int){
        _point.value = _point.value?.let {
            val newAnswer = newValue
            newAnswer
        }?: UNCHECKED_POINT
        repository.postPoint(_point.value?: UNCHECKED_POINT)
    }

    fun setPoint(newValue: Int){
        modifyPoint(newValue)
    }
}