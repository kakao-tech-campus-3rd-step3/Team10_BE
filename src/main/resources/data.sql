-- 퀴즈 토픽 데이터 삽입
INSERT INTO quiz_topic (name, created_at, updated_at)
VALUES
    ('경제기초',     NOW(), NOW()),
    ('주식투자',     NOW(), NOW()),
    ('글로벌 경제', NOW(), NOW()),
    ('생활 경제',   NOW(), NOW()),
    ('부동산',      NOW(), NOW());

-- OX 퀴즈 데이터 삽입
INSERT INTO quiz (
    topic_id,
    question_title,
    question_type,
    question_data,
    difficulty_level,
    explanation,
    question_order,
    correct_rate,
    created_at,
    updated_at
)
VALUES
    (1,
     '인플레이션은 물가 상승을 의미한다',
     'OX',
     '{"correctAnswer": true}',
     'EASY',
     '인플레이션은 일반적인 물가 수준이 지속적으로 상승하는 현상을 말합니다.',
     1,
     0.00,
     NOW(),
     NOW()
    ),
    (2,
     '주식의 액면가는 시장가격과 항상 같다',
     'OX',
     '{"correctAnswer": false}',
     'MEDIUM',
     '주식의 액면가는 주식 발행 시 정해진 명목상의 가격이고, 시장가격은 수요와 공급에 따라 결정되는 실제 거래 가격입니다.',
     2,
     0.00,
     NOW(),
     NOW()
    ),
    (3,
     '미국의 기준금리 인상은 전 세계 경제에 영향을 미친다',
     'OX',
     '{"correctAnswer": true}',
     'HARD',
     '미국 달러는 기축통화로서 미국의 금리 정책은 자본 흐름과 환율에 영향을 주어 전 세계 경제에 파급효과를 미칩니다.',
     3,
     0.00,
     NOW(),
     NOW()
    ),
    (4,
     '신용카드 리볼빙 서비스는 무이자로 이용할 수 있다',
     'OX',
     '{"correctAnswer": false}',
     'EASY',
     '신용카드 리볼빙 서비스는 미납금에 대해 높은 이자율(연 15-25%)이 적용되는 단기 대출 서비스입니다.',
     4,
     0.00,
     NOW(),
     NOW()
    ),
    (5,
     '전세금 반환보증보험은 의무적으로 가입해야 한다',
     'OX',
     '{"correctAnswer": false}',
     'MEDIUM',
     '전세금 반환보증보험은 임차인이 선택적으로 가입할 수 있는 보험 상품이며, 의무사항은 아닙니다.',
     5,
     0.00,
     NOW(),
     NOW()
    );
