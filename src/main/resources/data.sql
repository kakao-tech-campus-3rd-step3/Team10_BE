-- 퀴즈 토픽 데이터 삽입
INSERT INTO quiz_topic (name, created_at, updated_at)
VALUES
    ('경제기초',     NOW(), NOW()),
    ('주식투자',     NOW(), NOW()),
    ('글로벌 경제', NOW(), NOW()),
    ('생활 경제',   NOW(), NOW()),
    ('부동산',      NOW(), NOW());

-- OX 퀴즈 데이터 삽입
INSERT INTO quiz
    (
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
 '국내총생산(GDP)은 한 나라 안에서 생산된 모든 재화와 서비스의 시장 가치를 합한 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '국내총생산(GDP)은 한 나라 안에서 생산된 모든 재화와 서비스의 시장 가치를 합한 것입니다.',
 1,
 0.00, NOW(), NOW()
),
(1,
 '국내총생산(GDP)은 소비자가 일상적으로 구매하는 상품과 서비스의 평균적인 가격 변동을 나타내는 지표이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 소비자물가지수(CPI)에 대한 설명입니다. GDP는 한 나라 안에서 생산된 모든 재화와 서비스의 시장 가치를 합한 것입니다.',
 2,
 0.00, NOW(), NOW()
),

(1,
 '국내총생산(GDP)은 한 나라의 국민이 국내와 해외에서 벌어들인 모든 소득을 합친 지표이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 국민총소득(GNI)에 대한 설명입니다. GDP는 한 나라 안에서 생산된 모든 재화와 서비스의 시장 가치를 합한 것입니다.',
 3,
 0.00, NOW(), NOW()
),

(1,
 '인플레이션은 통화가 늘어나 화폐 가치가 하락하고, 전반적인 물가 수준이 꾸준히 오르는 현상이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '인플레이션은 통화가 늘어나 화폐 가치가 하락하고, 전반적인 물가 수준이 꾸준히 오르는 현상을 의미합니다.',
 4,
 0.00, NOW(), NOW()
),

(1,
 '인플레이션은 경기 침체와 물가 상승이 동시에 발생하는 현상이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 스태그플레이션에 대한 설명입니다. 인플레이션은 전반적인 물가 수준이 꾸준히 오르는 현상입니다.',
 5,
 0.00, NOW(), NOW()
),

(1,
 '인플레이션은 물가가 지속적으로 하락하여 돈의 가치가 올라가는 현상이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 디플레이션에 대한 설명입니다. 인플레이션은 물가가 지속적으로 상승하는 현상입니다.',
 6,
 0.00, NOW(), NOW()
),

(1,
 '기준금리는 중앙은행이 시중의 통화량을 조절하기 위해 사용하는 정책 금리이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '기준금리는 중앙은행이 시중의 통화량을 조절하기 위해 사용하는 정책 금리이며, 통화 정책의 핵심 수단입니다.',
 7,
 0.00, NOW(), NOW()
),

(1,
 '기준금리는 은행에서 돈을 빌렸을 때 우리가 은행에 내야 하는 이자의 비율이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 대출금리에 대한 설명입니다. 기준금리는 중앙은행이 사용하는 정책 금리입니다.',
 8,
 0.00, NOW(), NOW()
),

(1,
 '기준금리는 시장의 자금 수요와 공급에 따라 자연스럽게 형성되는 금리이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 시장금리에 대한 설명입니다. 기준금리는 중앙은행이 정책적으로 결정하는 금리입니다.',
 9,
 0.00, NOW(), NOW()
),

(1,
 '기회비용은 어떤 것을 선택함으로써 포기해야 하는 다른 선택의 가치 중 가장 큰 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '기회비용은 어떤 것을 선택함으로써 포기해야 하는 다른 선택의 가치 중 가장 큰 것을 의미합니다.',
 10,
 0.00, NOW(), NOW()
),

(1,
 '기회비용은 이미 지불해서 다시 회수할 수 없는 비용이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 매몰비용에 대한 설명입니다. 기회비용은 포기해야 하는 가치 중 가장 큰 것입니다.',
 11,
 0.00, NOW(), NOW()
),

(1,
 '기회비용은 물건을 한 개 더 생산할 때 추가로 드는 비용이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 한계비용에 대한 설명입니다. 기회비용은 포기해야 하는 가치 중 가장 큰 것입니다.',
 12,
 0.00, NOW(), NOW()
),

(1,
 '수요의 법칙은 상품의 가격이 오르면 수요량이 감소하는 현상을 말한다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '수요의 법칙은 가격과 수요량 사이의 반비례 관계를 설명하며, 가격이 오르면 수요량이 감소하고 가격이 내리면 수요량이 증가합니다.',
 13,
 0.00, NOW(), NOW()
),

(1,
 '수요의 법칙은 가격이 오르면 공급량이 늘어나는 생산자 입장에서의 법칙이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 공급의 법칙에 대한 설명입니다. 수요의 법칙은 가격과 수요량의 반비례 관계를 설명합니다.',
 14,
 0.00, NOW(), NOW()
),

(1,
 '수요의 법칙은 재화를 소비할수록 추가로 얻는 만족감이 점점 줄어드는 현상이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 한계효용 체감의 법칙에 대한 설명입니다. 수요의 법칙은 가격과 수요량의 반비례 관계를 설명합니다.',
 15,
 0.00, NOW(), NOW()
),

(1,
 '배당은 주식회사가 이익의 일부를 주주들에게 나누어 주는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '배당은 기업이 영업 활동을 통해 얻은 이익을 주주들에게 그들이 가진 주식 지분에 따라 분배하는 것입니다.',
 16,
 0.00, NOW(), NOW()
),

(1,
 '배당은 주식을 산 가격보다 비싼 가격에 팔아서 얻는 이익이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 시세차익에 대한 설명입니다. 배당은 회사가 이익을 주주에게 나누어 주는 것입니다.',
 17,
 0.00, NOW(), NOW()
),

(1,
 '배당은 회사가 돈을 받고 새로 주식을 발행하여 자본금을 늘리는 것이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 유상증자에 대한 설명입니다. 배당은 회사가 이익을 주주에게 나누어 주는 것입니다.',
 18,
 0.00, NOW(), NOW()
),

(1,
 '환율은 서로 다른 두 나라의 화폐를 교환하는 비율이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY', '환율은 서로 다른 두 나라의 화폐를 교환하는 비율로, 국가 간 거래의 기준이 됩니다.',
 19,
 0.00, NOW(), NOW()
),

(1,
 '환율은 돈의 가격, 즉 이자율을 의미한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 금리에 대한 설명입니다. 환율은 두 나라 화폐의 교환 비율입니다.',
 20,
 0.00, NOW(), NOW()
),

(1,
 '환율은 주식 1주당 가격을 의미한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 주가에 대한 설명입니다. 환율은 두 나라 화폐의 교환 비율입니다.',
 21,
 0.00, NOW(), NOW()
),

(1,
 '재정은 정부가 세금을 걷고 공공사업 등에 돈을 사용하는 경제 활동을 말한다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '재정은 정부가 세금을 걷고 공공사업 등에 돈을 사용하는 경제 활동으로, 나라의 살림살이를 의미합니다.',
 22,
 0.00, NOW(), NOW()
),

(1,
 '재정은 돈이 필요한 곳과 여유 있는 곳을 연결해주는 자금의 융통 활동이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 금융에 대한 설명입니다. 재정은 정부의 경제 활동을 의미합니다.',
 23,
 0.00, NOW(), NOW()
),

(1,
 '누진세는 소득이 높을수록 더 높은 세율을 적용하는 세금 제도이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '누진세는 소득 구간을 나누어 소득이 높은 구간일수록 더 높은 세율을 적용하는 방식으로, 소득 재분배 효과를 목적으로 합니다.',
 24,
 0.00, NOW(), NOW()
),

(1,
 '누진세는 소득 수준과 관계없이 모두에게 똑같은 세율을 적용하는 세금이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 비례세에 대한 설명입니다. 누진세는 소득이 높을수록 더 높은 세율을 적용합니다.',
 25,
 0.00, NOW(), NOW()
),

(1,
 '누진세는 세금을 내는 사람과 실제로 부담하는 사람이 다른 세금이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 간접세에 대한 설명입니다. 누진세는 소득세와 같은 직접세의 일종입니다.',
 26,
 0.00, NOW(), NOW()
),

(1,
 '채권은 정부나 기업이 자금을 조달하기 위해 발행하는, 원금과 이자를 갚겠다고 약속하는 증서이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '채권은 정부나 기업이 자금을 조달하기 위해 발행하며, 만기 시 원금과 약속된 이자를 지급할 의무를 가집니다.',
 27,
 0.00, NOW(), NOW()
),

(1,
 '채권은 회사의 소유권을 나타내는 증서이며 원금 보장이 되지 않는다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 주식에 대한 설명입니다. 채권은 소유권이 아닌, 돈을 빌렸다는 증서입니다.',
 28,
 0.00, NOW(), NOW()
),

(1,
 '채권은 여러 사람의 돈을 모아 전문가가 대신 투자해주는 간접 투자 상품이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 펀드에 대한 설명입니다. 채권은 정부나 기업이 발행하는 채무 증서입니다.',
 29,
 0.00, NOW(), NOW()
),

(1,
 '자원의 희소성은 인간의 욕구는 무한하지만 자원은 한정되어 있다는 것을 의미한다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '자원의 희소성은 인간의 욕구는 무한하지만 그것을 충족시켜 줄 자원은 한정되어 있다는 경제학의 기본 전제로, 모든 경제 문제의 근원입니다.',
 30,
 0.00, NOW(), NOW()
),

(1,
 '자원의 희소성은 시장의 자동 조절 기능을 비유한 말이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'보이지 않는 손\'에 대한 설명입니다. 자원의 희소성은 욕구 대비 자원이 부족한 상태를 말합니다.',
 31,
 0.00, NOW(), NOW()
),

(1,
 'FTA(자유무역협정)는 국가 간 무역 장벽을 낮추어 교역을 확대하기 위한 협정이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 'FTA는 협정을 맺은 특정 국가들끼리 관세 등 무역 장볍을 철폐하거나 낮추어 교역을 증진시키는 협정입니다.',
 32,
 0.00, NOW(), NOW()
),

(1,
 'FTA(자유무역협정)는 전 세계 국가들이 참여하여 무역 분쟁을 해결하는 국제기구이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 WTO(세계무역기구)에 대한 설명입니다. FTA는 국가 간의 양자간 또는 지역적 협정입니다.',
 33,
 0.00, NOW(), NOW()
),

(1,
 '이자는 돈을 빌린 대가로 지불하거나 빌려준 대가로 받는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '이자는 돈을 빌린 대가(대출이자)로 지불하거나, 돈을 빌려준 대가(예금이자)로 받는 것입니다.',
 34,
 0.00, NOW(), NOW()
),

(1,
 '이자는 처음에 빌리거나 빌려준 돈의 원래 액수를 말한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 원금에 대한 설명입니다. 이자는 그 원금에 대해 발생하는 대가입니다.',
 35,
 0.00, NOW(), NOW()
),

(1,
 '분배는 생산 요소를 제공한 대가로 소득이 돌아가는 것을 의미한다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '분배는 생산 활동을 통해 창출된 가치(소득)을 노동, 자본, 토지 등 생산 요소를 제공한 각 경제 주체에게 나누어 주는 과정입니다.',
 36,
 0.00, NOW(), NOW()
),

(1,
 '분배는 재화나 서비스를 사용하여 만족을 얻는 행위를 말한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 소비에 대한 설명입니다. 분배는 생산의 대가를 나누는 과정입니다.',
 37,
 0.00, NOW(), NOW()
),

(1,
 '\'보이지 않는 손\'은 시장의 자동 조절 기능을 비유적으로 표현한 말이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '애덤 스미스의 \'보이지 않는 손\'은 각 경제 주체가 자신의 이익을 추구하는 과정에서 사회 전체의 이익이 효율적으로 달성된다는 시장 가격의 자동 조절 기능을 비유한 말입니다.',
 38,
 0.00, NOW(), NOW()
),

(1,
 '\'보이지 않는 손\'은 협력하면 모두에게 이익이 됨에도 서로에게 불리한 선택을 하는 상황을 말한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'죄수의 딜레마\'에 대한 설명입니다. \'보이지 않는 손\'은 시장의 자동 조절 기능을 의미합니다.',
 39,
 0.00, NOW(), NOW()
),

(1,
 '설비 투자는 기업이 생산 활동에 필요한 기계, 설비 등에 투자하는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '설비 투자는 미래의 생산 능력을 늘리기 위해 기계, 설비, 건물 등 고정 자산을 취득하는 활동입니다.',
 40,
 0.00, NOW(), NOW()
),

(1,
 '설비 투자는 이익을 얻을 목적으로 주식, 채권 같은 금융 자산을 사는 활동이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 금융 투자에 대한 설명입니다. 설비 투자는 생산 능력을 늘리기 위한 실물 투자입니다.',
 41,
 0.00, NOW(), NOW()
),

(1,
 '실업률은 일할 의사와 능력이 있지만 일자리를 구하지 못한 사람의 비율이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '실업률은 경제활동인구 중에서 실업자가 차지하는 비율로, 고용 시장의 상황을 보여주는 지표입니다.',
 42,
 0.00, NOW(), NOW()
),

(1,
 '실업률은 일할 수 있는 나이의 인구 중 실제로 취업한 사람의 비율이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 고용률에 대한 설명입니다. 실업률은 일자리를 \'구하지 못한\' 사람의 비율입니다.',
 43,
 0.00, NOW(), NOW()
),

(1,
 '분산 투자는 여러 투자 상품에 돈을 나누어 투자함으로써 위험을 줄이는 전략이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '분산 투자는 \'계란을 한 바구니에 담지 말라\'는 격언처럼, 서로 다른 자산에 나누어 투자하여 위험을 관리하는 기법입니다.',
 44,
 0.00, NOW(), NOW()
),

(1,
 '분산 투자는 한 가지 자산에 모든 돈을 투자하는 고위험 전략이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'몰빵 투자\'에 대한 설명입니다. 분산 투자는 위험을 줄이기 위해 투자를 나누는 전략입니다.',
 45,
 0.00, NOW(), NOW()
),

(1,
 '경제학은 희소한 자원을 어떻게 효율적으로 배분할 것인가를 연구하는 학문이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '경제학은 생산, 소비, 분배 등 인간의 경제 활동과 희소한 자원의 효율적 배분을 연구하는 학문입니다.',
 46,
 0.00, NOW(), NOW()
),

(1,
 '경제학은 기업을 효율적으로 관리하고 운영하는 방법을 연구하는 학문이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 경영학에 대한 설명입니다. 경제학은 자원의 배분과 같은 더 넓은 범위의 경제 활동을 연구합니다.',
 47,
 0.00, NOW(), NOW()
),

(1,
 '무역수지는 한 나라의 \'상품\' 수출액과 수입액의 차이이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '무역수지는 국가 간의 거래 중 오직 \'상품\'의 수출액과 수입액만을 비교한 값입니다.',
 48,
 0.00, NOW(), NOW()
),

(1,
 '무역수지는 상품 거래 외에 서비스, 해외 소득 등 모든 대외 거래 결과를 포함한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 경상수지에 대한 설명입니다. 무역수지는 경상수지의 한 항목으로, \'상품\' 거래만을 다룹니다.',
 49,
 0.00, NOW(), NOW()
),

(1,
 '현행 예금자보호법에 따라 금융회사가 파산하더라도 1인당 보호받을 수 있는 최고 금액은 1억 원이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '예금자보호법에 따라 1인당 보호 한도는 (법 개정으로) 최고 1억 원입니다.',
 50,
 0.00, NOW(), NOW()
),

(1,
 '현행 예금자보호법에 따라 1인당 보호받을 수 있는 최고 금액은 5천만 원이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '5천만 원은 과거의 보호 한도이며, 법 개정으로 1인당 최고 보호 금액은 1억 원입니다.',
 51,
 0.00, NOW(), NOW()
),

(1,
 '주가지수는 주식 시장 전체의 움직임을 나타내는 대표적인 지표이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '주가지수는 시장에 상장된 주식들의 가격을 종합하여 하나의 숫자로 나타낸 것으로, 코스피, 나스닥 지수 등이 이에 해당합니다.',
 52,
 0.00, NOW(), NOW()
),

(1,
 '주가지수는 외환 시장의 상황을 보여주는 지표이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 환율에 대한 설명입니다. 주가지수는 \'주식\' 시장의 움직임을 나타냅니다.',
 53,
 0.00, NOW(), NOW()
),

(1,
 '소득세는 개인이 경제 활동을 통해 얻은 \'소득\'에 대해 직접 부과되는 세금이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '소득세는 개인이 근로, 사업, 이자, 배당 등 경제 활동을 통해 얻은 ‘소득’에 대해 직접 부과되는 세금입니다.',
 54,
 0.00, NOW(), NOW()
),

(1,
 '소득세는 물건을 \'소비\'할 때 가격에 포함되어 내는 세금이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 부가가치세에 대한 설명입니다. 소득세는 개인이 번 \'소득\'에 대해 부과됩니다.',
 55,
 0.00, NOW(), NOW()
),

(1,
 '국민연금은 노후 생활 안정을 위해 국가가 시행하는 사회보험 제도이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '국민연금은 소득 활동을 할 때 보험료를 납부했다가, 나이가 들어 생업에 종사할 수 없게 될 때 연금을 받아 노후 생활을 지원하는 사회보장제도입니다.',
 56,
 0.00, NOW(), NOW()
),

(1,
 '국민연금은 실직했을 때 실업급여를 주고 재취업을 돕는 제도이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 고용보험에 대한 설명입니다. 국민연금은 \'노후\' 생활 안정을 위한 제도입니다.',
 57,
 0.00, NOW(), NOW()
),

(1,
 '신용점수는 개인의 금융 거래 정보를 바탕으로 신용도를 1점에서 1000점까지의 점수로 산출한 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '신용점수는 개인의 대출 상환 이력, 카드 사용 내역 등 다양한 금융 거래 정보를 바탕으로 신용도를 점수로 산출한 것입니다.',
 58,
 0.00, NOW(), NOW()
),

(1,
 '신용점수는 현재 1등급부터 10등급까지의 등급으로 나누어 사용한다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 과거의 \'신용 등급\' 방식입니다. 현재는 1~1000점의 \'신용점수\' 제도를 사용합니다.',
 59,
 0.00, NOW(), NOW()
),

(1,
 '슈링크플레이션은 가격은 그대로 두면서 제품의 양을 줄여 실질적으로 가격을 인상하는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '\'슈링크플레이션\'은 \'줄어들다(shrink)\'와 \'인플레이션(inflation)\'의 합성어로, 가격은 유지한 채 용량을 줄이는 것을 말합니다.',
 60,
 0.00, NOW(), NOW()
),

(1,
 '슈링크플레이션은 양은 그대로지만 원재료의 질을 낮추어 원가를 절감하는 것이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'스킴플레이션(Skimflation)\'에 대한 설명입니다. 슈링크플레이션은 \'양\'을 줄이는 것입니다.',
 61,
 0.00, NOW(), NOW()
),

(1,
 '간접세는 세금을 내야 할 사람과 실제로 부담하는 사람이 다른 세금이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '간접세는 납세자(사업자)가 세금 부담을 상품 가격에 포함시켜 최종 소비자(담세자)에게 전가하는 형태의 세금이며, 부가가치세가 대표적입니다.',
 62,
 0.00, NOW(), NOW()
),

(1,
 '간접세는 소득세처럼 세금을 내는 사람과 부담하는 사람이 같은 세금이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 직접세에 대한 설명입니다. 간접세는 납세자와 담세자가 다릅니다.',
 63,
 0.00, NOW(), NOW()
),

(1,
 '핀테크는 \'금융(Finance)\'과 \'기술(Technology)\'의 합성어이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '핀테크는 모바일 결제, 인터넷 전문은행 등 정보 기술을 기반으로 한 새로운 형태의 금융서비스를 총칭합니다.',
 64,
 0.00, NOW(), NOW()
),

(1,
 '핀테크는 환경 보호, 신재생에너지 등 친환경 사업에 투자하는 금융 활동이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'그린 금융\'에 대한 설명입니다. 핀테크는 금융과 \'기술\'의 결합을 의미합니다.',
 65,
 0.00, NOW(), NOW()
),

(1,
 '한계 비용은 생산량을 한 단위 늘릴 때 추가로 발생하는 비용이다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '한계 비용은 제품을 딱 한 개 더 만들 때 추가로 드는 비용으로, 기업이 생산량을 결정할 때 중요한 기준이 됩니다.',
 66,
 0.00, NOW(), NOW()
),

(1,
 '한계 비용은 제품 1개당 들어간 평균적인 비용이다.',
 'OX',
 '{"correctAnswer": false}',
 'EASY',
 '이는 \'평균 비용\'에 대한 설명입니다. 한계 비용은 \'추가 한 단위\'를 생산할 때 드는 비용입니다.',
 67,
 0.00, NOW(), NOW()
);

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
-- 1
(2,
 '주식을 사려면 증권 계좌가 반드시 필요하다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '주식 매매를 하기 위해선 반드시 증권사에서 계좌를 개설해야 하며, MTS나 HTS 등을 통해 거래한다.',
 1,
 0.00,
 NOW(),
 NOW()
),
-- 2
(2,
 '코스피는 한국의 대표적인 주식 시장 지수이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '코스피(KOSPI)는 한국거래소에 상장된 대형 우량주들의 주가를 종합한 대표 지수로, 한국 주식시장 전체 흐름을 나타낸다.',
 2,
 0.00,
 NOW(),
 NOW()
),
-- 3
(2,
 '‘상한가’는 하루에 주가가 오를 수 있는 최대 한도를 뜻한다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '주식 시장은 과도한 급등락을 막기 위해 상한가/하한가 제도를 운영하며, 하루 변동폭을 일정 수준으로 제한한다.',
 3,
 0.00,
 NOW(),
 NOW()
),
-- 5
(2,
 '다음 중 주식을 사기 위해 사용하는 앱이나 프로그램은 무엇인가요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "홈쇼핑", "correctAnswer": false},
      {"text": "메신저", "correctAnswer": false},
      {"text": "HTS/MTS", "correctAnswer": true},
      {"text": "블로그", "correctAnswer": false}
    ]
  }',
 'EASY',
 'HTS(Home Trading System)는 컴퓨터용, MTS(Mobile Trading System)는 스마트폰용 주식 매매 시스템이다.',
 5,
 0.00,
 NOW(),
 NOW()
),
-- 6
(2,
 '배당은 주식을 보유한 사람에게 회사가 나눠주는 돈이다.',
 'OX',
 '{"correctAnswer": true}',
 'HARD',
 '회사가 벌어들인 이익의 일부를 주주에게 분배하는 것이 배당이며, 장기 투자자에게 중요한 수익원 중 하나다.',
 6,
 0.00,
 NOW(),
 NOW()
),
-- 7
(2,
 '주가가 올라서 이익을 보는 걸 ‘손실’이라고 한다.',
 'OX',
 '{"correctAnswer": false}',
 'MEDIUM',
 '주가가 올라서 이익이 나는 건 ‘수익’, 반대로 주가가 떨어져 손해가 나는 건 ‘손실’이다.',
 7,
 0.00,
 NOW(),
 NOW()
),
-- 9
(2,
 '주식 거래는 보통 무슨 요일에 안 되나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "월요일", "correctAnswer": false},
      {"text": "수요일", "correctAnswer": false},
      {"text": "토요일", "correctAnswer": true},
      {"text": "금요일", "correctAnswer": false}
    ]
  }',
 'EASY',
 '주식 거래는 평일(월~금) 09:00~15:30에 가능하며, 주말과 공휴일은 휴장이다.',
 9,
 0.00,
 NOW(),
 NOW()
),
-- 10
(2,
 '다음 중 주식 시장이 여는 시간을 무엇이라 하나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "마감", "correctAnswer": false},
      {"text": "시가", "correctAnswer": true},
      {"text": "종가", "correctAnswer": false},
      {"text": "상장", "correctAnswer": false}
    ]
  }',
 'MEDIUM',
 '시가는 시장이 열릴 때 형성된 첫 가격이며, 그날의 투자 심리를 반영하는 지표가 되기도 한다.',
 10,
 0.00,
 NOW(),
 NOW()
),
-- 11
(2,
 '기업이 상장되면 일반 투자자들도 주식을 살 수 있다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '상장은 기업이 주식 시장에 주식을 공개적으로 판매하는 것을 말하며, 상장 이후 누구나 해당 주식을 매매할 수 있다.',
 11,
 0.00,
 NOW(),
 NOW()
),
-- 13
(2,
 'PER은 주가가 회사 이익의 몇 배인지 나타내는 지표다.',
 'OX',
 '{"correctAnswer": true}',
 'HARD',
 'PER은 Price Earning Ratio의 약자로, 낮을수록 이익 대비 주가가 저평가되었을 수 있다.',
 13,
 0.00,
 NOW(),
 NOW()
),
-- 14
(2,
 '고PER 종목은 보통 어떤 특징을 가질까요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "저평가된 가치주", "correctAnswer": false},
      {"text": "고성장을 기대받는 종목", "correctAnswer": true},
      {"text": "배당 위주의 안정주", "correctAnswer": false},
      {"text": "이미 상장 폐지된 종목", "correctAnswer": false}
    ]
  }',
 'HARD',
 '고PER은 현재 이익은 적지만 미래의 성장성이 크다고 시장이 판단할 때 나타나는 현상이다.',
 14,
 0.00,
 NOW(),
 NOW()
),
-- 15
(2,
 '개미 투자자는 기관투자자를 의미한다.',
 'OX',
 '{"correctAnswer": false}',
 'MEDIUM',
 '개미는 일반 개인 투자자를 지칭하며, 기관이나 외국인 투자자에 비해 정보력과 자금력이 약하다.',
 15,
 0.00,
 NOW(),
 NOW()
),
-- 16
(2,
 '주식 시장에서 ‘호가창’은 어떤 정보를 보여주나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "과거 거래 이력", "correctAnswer": false},
      {"text": "배당 내역", "correctAnswer": false},
      {"text": "현재 사고파는 가격", "correctAnswer": true},
      {"text": "회사 매출", "correctAnswer": false}
    ]
  }',
 'MEDIUM',
 '호가창은 매수자와 매도자가 제시한 가격을 보여주는 창으로, 실시간 수급 상황을 알 수 있다.',
 16,
 0.00,
 NOW(),
 NOW()
),
-- 17
(2,
 '‘손절’은 손해를 보더라도 주식을 파는 것을 뜻한다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '손절은 손실이 더 커지기 전에 주식을 파는 전략으로, 감정에 휘둘리지 않는 손절매는 중요한 리스크 관리 수단이다.',
 17,
 0.00,
 NOW(),
 NOW()
),
-- 19
(2,
 '주가 차트를 분석하며 타이밍을 잡는 방식을 무엇이라 하나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "가치 투자", "correctAnswer": false},
      {"text": "모멘텀 투자", "correctAnswer": false},
      {"text": "기술적 분석", "correctAnswer": true},
      {"text": "펀더멘털 분석", "correctAnswer": false}
    ]
  }',
 'HARD',
 '기술적 분석은 거래량과 차트 패턴을 통해 단기 매매 타이밍을 잡으려는 분석 방식이다.',
 19,
 0.00,
 NOW(),
 NOW()
),
-- 20
(2,
 '‘유상증자’는 회사가 주식을 더 발행해서 자금을 받는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '유상증자는 신주를 발행해 투자자로부터 돈을 받고 자본금을 늘리는 방식이다. 기존 주주 입장에선 지분 희석이 발생할 수 있다.',
 20,
 0.00,
 NOW(),
 NOW()
),
-- 22
(2,
 '‘유동성’이 높다는 말은 주식을 쉽게 사고팔 수 있다는 뜻이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '유동성이 높은 주식은 거래가 활발하게 이뤄져 사고팔기 쉬우며, 매수자와 매도자가 많아 체결이 빠르다.',
 22,
 0.00,
 NOW(),
 NOW()
),
-- 23
(2,
 '액면분할은 한 주의 가치를 나눠 주식 수를 늘리는 것이다.',
 'OX',
 '{"correctAnswer": true}',
 'HARD',
 '액면분할은 1주의 액면가를 낮추고 주식 수를 늘리는 방식으로, 주가를 낮춰 소액 투자자 접근성을 높인다.',
 23,
 0.00,
 NOW(),
 NOW()
),
-- 24
(2,
 '다음 중 개별 종목이 아니라 여러 종목을 묶어 지수처럼 운용되는 상품은?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "코인", "correctAnswer": false},
      {"text": "ETF", "correctAnswer": true},
      {"text": "원유선물", "correctAnswer": false},
      {"text": "펀드매니저", "correctAnswer": false}
    ]
  }',
 'MEDIUM',
 'ETF는 여러 종목이나 자산을 묶어 만든 펀드를 주식처럼 실시간으로 거래할 수 있도록 만든 상품이다.',
 24,
 0.00,
 NOW(),
 NOW()
),
-- 25
(2,
 '‘시가총액’은 어떻게 계산하나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "주가 × 거래량", "correctAnswer": false},
      {"text": "주가 × 발행 주식 수", "correctAnswer": true},
      {"text": "배당금 총액", "correctAnswer": false},
      {"text": "PER × PBR", "correctAnswer": false}
    ]
  }',
 'MEDIUM',
 '시가총액은 주가에 전체 발행 주식 수를 곱해 계산하며, 이는 기업의 시장 내 가치를 나타내는 핵심 지표다.',
 25,
 0.00,
 NOW(),
 NOW()
),
-- 26
(2,
 '분산 투자는 리스크를 줄이는 데 효과적이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '다양한 종목에 투자하면 특정 종목의 하락 위험을 분산시킬 수 있어 손실 위험을 줄이는 데 효과적이다.',
 26,
 0.00,
 NOW(),
 NOW()
),
-- 28
(2,
 '다음 중 \'소형테마주(잡주)\'에 해당하는 특징은?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "시총이 크고 거래량 많음", "correctAnswer": false},
      {"text": "재무구조 탄탄함", "correctAnswer": false},
      {"text": "급등락 심하고 정보 부족", "correctAnswer": true},
      {"text": "배당금 지급 확실함", "correctAnswer": false}
    ]
  }',
 'MEDIUM',
 '잡주는 기업 규모가 작고, 정보가 부족하며, 가격 변동성이 커 투기성 매매 대상이 되는 종목이다.',
 28,
 0.00,
 NOW(),
 NOW()
),
-- 30
(2,
 '종가는 장 마감 시 형성되는 가격이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '종가는 하루 거래가 끝나는 시점에서 최종적으로 체결된 가격이며, 다음 날 주가에 영향을 줄 수 있다.',
 30,
 0.00,
 NOW(),
 NOW()
),
-- 33
(2,
 '주가가 하락했을 때 같은 주식을 추가로 매수해 평균 단가를 낮추는 전략은 효과적인 투자법이다.',
 'OX',
 '{"correctAnswer": false}',
 'MEDIUM',
 '물타기는 잘못된 판단일 경우 손실을 키울 수 있는 위험한 전략이다.',
 33,
 0.00,
 NOW(),
 NOW()
),
-- 38
(2,
 '상승장이 지속되는 시장을 무엇이라 하나요?',
 'MULTIPLE_CHOICE',
 '{
    "choices": [
      {"text": "베어마켓", "correctAnswer": false},
      {"text": "불마켓", "correctAnswer": true},
      {"text": "횡보장", "correctAnswer": false},
      {"text": "고래장", "correctAnswer": false}
    ]
  }',
 'HARD',
 '불마켓은 시장이 낙관적인 분위기로 지속 상승하는 장세를 의미하며, 베어마켓은 그 반대다.',
 38,
 0.00,
 NOW(),
 NOW()
),
-- 39
(2,
 '투자의 가장 기본적인 원칙 중 하나는 리스크 관리이다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '리스크 관리는 손실을 줄이고 자산을 지키는 투자 전략의 핵심이다. 분산 투자, 손절 설정 등이 포함된다.',
 39,
 0.00,
 NOW(),
 NOW()
),
-- 40
(2,
 '배당을 받기 위해 주식을 반드시 보유해야 하는 마지막 날을 배당락일이라 한다.',
 'OX',
 '{"correctAnswer": false}',
 'HARD',
 '배당락일은 배당을 받을 수 없는 첫날이며, 권리락일 전날까지 주식을 보유해야 배당을 받을 수 있다.',
 40,
 0.00,
 NOW(),
 NOW()
),
-- 44
(2,
 '장 시작 시 전날 종가보다 훨씬 높은 가격에 거래가 시작되는 현상을 \'갭 상승\'이라 한다.',
 'OX',
 '{"correctAnswer": true}',
 'HARD',
 '갭 상승은 장 시작 전 발생한 호재나 외국인 수급 등의 영향으로 시가가 급등하며 시작하는 현상이다.',
 44,
 0.00,
 NOW(),
 NOW()
),
-- 48
(2,
 '투자자는 기업의 공시 내용을 확인해야 할 책임이 있다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '공시는 기업이 투자자에게 제공하는 공식 정보이므로, 이를 확인하지 않고 투자하는 것은 위험한 판단이다.',
 48,
 0.00,
 NOW(),
 NOW()
),
-- 49
(2,
 '수익률이 높다고 해서 무조건 수익금이 많은 것은 아니다.',
 'OX',
 '{"correctAnswer": true}',
 'EASY',
 '수익률은 투자금 대비 비율이며, 투자 원금이 작으면 수익률이 높아도 실제 수익금은 적을 수 있다.',
 49,
 0.00,
 NOW(),
 NOW()
),
-- 50
(2,
 '탐욕과 공포는 투자 수익률에 큰 영향을 줄 수 있다.',
 'OX',
 '{"correctAnswer": true}',
 'MEDIUM',
 '투자 심리는 시장 판단과 매수/매도 타이밍에 영향을 주며, 과도한 감정은 잘못된 결정을 유발할 수 있다.',
 50,
 0.00,
 NOW(),
 NOW()
);

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
) VALUES
(3,
'기축통화국이 국제 유동성을 공급하기 위해 지속적인 경상수지 적자를 감수해야 하는 모순적 상황을 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "불가능한 삼위일체 (Impossible Trinity)", "correctAnswer": false},
    {"text": "트리핀의 딜레마 (Triffin Dilemma)", "correctAnswer": true},
    {"text": "유동성 함정 (Liquidity Trap)", "correctAnswer": false},
    {"text": "달러 스마일 이론 (Dollar Smile Theory)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'달러가 기축통화로서 역할을 유지하려면 미국은 계속해서 달러를 공급해야 하고, 이로 인해 신뢰도가 약화되는 모순을 설명한 개념이다.',
1,
0.00,
NOW(),
NOW()
),
(3,
'중앙은행이 기준금리가 0에 가까운 상황에서 국채 등을 매입하여 시중 유동성을 늘리는 비전통적 통화정책은?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "테이퍼링 (Tapering)", "correctAnswer": false},
    {"text": "양적완화 (Quantitative Easing)", "correctAnswer": true},
    {"text": "재정확대 (Fiscal Expansion)", "correctAnswer": false},
    {"text": "신용완화 (Credit Easing)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'채권 매입을 통해 장기금리를 낮추고 경기 회복을 유도하는 정책이다.',
2,
0.00,
NOW(),
NOW()
),
(3,
'한 국가가 자국의 경제 회복을 위해 환율을 인위적으로 낮추거나 관세를 높여 타국 경제에 피해를 주는 정책은?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "자유무역 정책 (Free Trade Policy)", "correctAnswer": false},
    {"text": "경쟁적 평가절하 (Competitive Devaluation)", "correctAnswer": false},
    {"text": "근린궁핍화 정책 (Beggar-thy-neighbor Policy)", "correctAnswer": true},
    {"text": "재정연방주의 (Fiscal Federalism)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'타국의 희생을 대가로 자국의 이익을 추구해 글로벌 무역을 위축시킬 수 있는 정책이다.',
3,
0.00,
NOW(),
NOW()
),
-- 4
(3,
'통화의 가치를 금의 일정량에 고정시켜 발행하는 제도는 무엇인가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "브레튼우즈 체제 (Bretton Woods System)", "correctAnswer": false},
    {"text": "금본위제 (Gold Standard)", "correctAnswer": true},
    {"text": "관리변동환율제 (Managed Float System)", "correctAnswer": false},
    {"text": "달러화 사용제 (Dollarization)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'통화 신뢰도를 높이지만 금 보유량 제약으로 경기 침체를 초래할 수 있었다.',
4,
0.00,
NOW(),
NOW()
),
-- 5
(3,
'제2차 세계대전 후 달러를 기축통화로 하고 금에 고정한 환율 제도를 수립한 체제는?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "워싱턴 컨센서스 (Washington Consensus)", "correctAnswer": false},
    {"text": "브레튼우즈 체제 (Bretton Woods System)", "correctAnswer": true},
    {"text": "플라자 합의 (Plaza Accord)", "correctAnswer": false},
    {"text": "마셜 플랜 (Marshall Plan)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'1944년 브레튼우즈 회의에서 IMF와 세계은행이 설립되며 달러 중심 국제통화체제가 확립되었다.',
5,
0.00,
NOW(),
NOW()
),
(3,
'1985년 미국, 일본, 독일, 프랑스, 영국이 달러 강세를 완화하기 위해 체결한 합의는?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "플라자 합의 (Plaza Accord)", "correctAnswer": true},
    {"text": "루브르 합의 (Louvre Accord)", "correctAnswer": false},
    {"text": "스미소니언 협정 (Smithsonian Agreement)", "correctAnswer": false},
    {"text": "도하 라운드 (Doha Round)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'미국의 무역적자 완화를 위해 주요국이 달러 약세를 유도한 합의로, 이후 엔화 가치가 급등했다.',
6,
0.00,
NOW(),
NOW()
),
(3,
'각국이 수출 경쟁력을 확보하기 위해 경쟁적으로 자국 통화 가치를 절하하는 현상은 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "디플레이션 악순환 (Deflation Spiral)", "correctAnswer": false},
    {"text": "환율 전쟁 (Currency War)", "correctAnswer": true},
    {"text": "평가절하 경쟁 (Devaluation Game)", "correctAnswer": false},
    {"text": "인플레이션 타게팅 (Inflation Targeting)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'수출 경쟁력 강화를 위해 통화가치를 낮추는 정책 경쟁을 의미한다.',
7,
0.00,
NOW(),
NOW()
),
(3,
'일물일가 법칙에 기반하여 환율이 각국 물가 수준을 반영해야 한다는 환율결정이론은 무엇인가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "비교우위 (Comparative Advantage)", "correctAnswer": false},
    {"text": "구매력 평가설 (Purchasing Power Parity)", "correctAnswer": true},
    {"text": "절대우위 (Absolute Advantage)", "correctAnswer": false},
    {"text": "일물일가의 법칙 (Law of One Price)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'PPP는 동일 재화의 가격이 환율을 반영하면 국가 간에 같아져야 한다는 이론이다.',
8,
0.00,
NOW(),
NOW()
),
(3,
'경기 침체 속에서도 물가가 오르는 현상을 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "초인플레이션 (Hyperinflation)", "correctAnswer": false},
    {"text": "디플레이션 (Deflation)", "correctAnswer": false},
    {"text": "스태그플레이션 (Stagflation)", "correctAnswer": true},
    {"text": "경기후퇴 (Recession)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'1970년대 오일쇼크 시 대표적으로 나타났으며 전통적 케인즈 이론의 한계를 드러냈다.',
9,
0.00,
NOW(),
NOW()
),
(3,
'1997년 외환위기 당시 한국이 외환 부족 사태를 해결하기 위해 어떤 국제기구로부터 구제금융을 받았는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "세계은행 (World Bank)", "correctAnswer": false},
    {"text": "국제통화기금 (IMF)", "correctAnswer": true},
    {"text": "경제협력개발기구 (OECD)", "correctAnswer": false},
    {"text": "세계무역기구 (WTO)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'한국은 1997년 IMF로부터 긴급자금을 지원받고 구조조정 및 긴축정책을 시행했다.',
10,
0.00,
NOW(),
NOW()
),
(3,
'BRICS는 브라질, 러시아, 인도, 중국, 남아프리카공화국을 포함한다.',
'OX',
'{"correctAnswer": true}',
'MEDIUM',
'2000년대 이후 신흥국 경제 협력체로 글로벌 성장의 주요 축으로 부상했다.',
11,
0.00,
NOW(),
NOW()
),
(3,
'보호무역주의는 단기적으로 국내 산업을 보호하지만, 장기적으로 산업 경쟁력을 약화시킬 수 있다.',
'OX',
'{"correctAnswer": true}',
'MEDIUM',
'외부 경쟁이 차단되면 기술혁신 유인이 줄어드는 역효과가 발생할 수 있다.',
12,
0.00,
NOW(),
NOW()
),
(3,
'신자유주의는 정부의 적극적 시장 개입을 강조하는 경제 사상이다.',
'OX',
'{"correctAnswer": false}',
'MEDIUM',
'신자유주의는 규제 완화와 민영화 등 시장의 자율성과 효율성을 강조한다.',
13,
0.00,
NOW(),
NOW()
),
-- 14
(2,
'세계화는 국가 간의 경제적, 문화적, 사회적 통합이 심화되는 현상을 의미한다.',
'OX',
'{"correctAnswer": true}',
'MEDIUM',
'무역, 기술, 금융의 통합이 세계화의 핵심 요인이다.',
14,
0.00,
NOW(),
NOW()
),
(3,
'다음 중 SDR(특별인출권, Special Drawing Rights)에 대한 설명으로 올바른 것은?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "IMF가 회원국에 무상으로 제공하는 구호기금이다.", "correctAnswer": false},
    {"text": "실제 통화로 사용되는 달러와 동일한 개념이다.", "correctAnswer": false},
    {"text": "IMF가 창출한 국제 준비자산으로, 달러·유로 등으로 구성된 가상통화이다.", "correctAnswer": true},
    {"text": "각국 중앙은행이 발행하는 법정화폐이다.", "correctAnswer": false}
  ]
}',
'MEDIUM',
'SDR은 달러, 유로, 위안, 엔, 파운드로 구성된 바스켓 기반의 국제 준비자산으로 결제와 준비금 용도로 활용된다.',
15,
0.00,
NOW(),
NOW()
),
(3,
'2010년대 초 유럽부채위기는 주로 남유럽 국가들의 과도한 정부 부채에서 비롯되었다.',
'OX',
'{"correctAnswer": true}',
'MEDIUM',
'그리스, 이탈리아, 스페인 등이 재정적자와 채무불이행 위험으로 큰 타격을 입었다.',
16,
0.00,
NOW(),
NOW()
),
(3,
'원유 거래가 대부분 달러로 이루어지는 국제 금융 시스템을 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "금본위제 (Gold Standard)", "correctAnswer": false},
    {"text": "브레튼우즈 체제 (Bretton Woods System)", "correctAnswer": false},
    {"text": "페트로달러 체제 (Petrodollar System)", "correctAnswer": true},
    {"text": "위안화 결제 시스템 (Yuan Settlement System)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'산유국이 달러 기반으로 원유를 거래하면서 미국의 통화 패권이 강화되었다.',
17,
0.00,
NOW(),
NOW()
),
(3,
'글로벌 경기 둔화에도 특정 국가의 경제가 독자적으로 성장하는 현상을 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "글로벌화 (Globalization)", "correctAnswer": false},
    {"text": "디커플링 (Decoupling)", "correctAnswer": true},
    {"text": "스태그플레이션 (Stagflation)", "correctAnswer": false},
    {"text": "탈세계화 (Deglobalization)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'한 국가의 경기 변동이 타국에 덜 전이되는 현상을 의미한다.',
18,
0.00,
NOW(),
NOW()
),
(3,
'경기 침체와 물가 상승이 동시에 발생하는 현상을 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "디플레이션 (Deflation)", "correctAnswer": false},
    {"text": "스태그플레이션 (Stagflation)", "correctAnswer": true},
    {"text": "초인플레이션 (Hyperinflation)", "correctAnswer": false},
    {"text": "리세션 (Recession)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'1970년대 오일쇼크 시기에 대표적으로 관찰된 현상이다.',
19,
0.00,
NOW(),
NOW()
),
(3,
'중앙은행이 발행하는 법정 디지털 화폐를 무엇이라 하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "중앙은행 디지털화폐 (CBDC)", "correctAnswer": true},
    {"text": "스테이블코인 (Stablecoin)", "correctAnswer": false},
    {"text": "비트코인 (Bitcoin)", "correctAnswer": false},
    {"text": "가상자산 (Virtual Asset)", "correctAnswer": false}
  ]
}',
'MEDIUM',
'중앙은행이 직접 발행·관리하는 국가 단위의 디지털 법정통화다.',
20,
0.00,
NOW(),
NOW()
),
(3,
'세계무역기구(WTO)의 주요 목적은 무엇인가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "무역 분쟁을 촉진하여 보호무역을 강화한다.", "correctAnswer": false},
    {"text": "자유무역 확대와 무역 분쟁 해결을 촉진한다.", "correctAnswer": true},
    {"text": "농업 보조금 정책을 확대한다.", "correctAnswer": false},
    {"text": "특정 국가에만 무역 특혜를 제공한다.", "correctAnswer": false}
  ]
}',
'MEDIUM',
'WTO는 상품·서비스·지식재산권 분야의 무역 규범을 총괄하며 자유무역과 분쟁 해결을 촉진한다.',
21,
0.00,
NOW(),
NOW()
),
(3,
'‘불가능의 삼각정리’는 다음 중 어떤 세 가지 목표를 동시에 달성할 수 없음을 의미하는가?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "물가 안정 – 실업률 감소 – 재정 균형", "correctAnswer": false},
    {"text": "고정환율제 – 자유로운 자본 이동 – 독립적 통화정책", "correctAnswer": true},
    {"text": "금본위제 – 자유무역 – 보호무역", "correctAnswer": false},
    {"text": "인플레이션 – 경기 부양 – 실질 성장", "correctAnswer": false}
  ]
}',
'MEDIUM',
'고정환율을 유지하면서 자본 이동의 자유와 독립적 금리정책을 동시에 유지하는 것은 불가능하다는 이론이다.',
22,
0.00,
NOW(),
NOW()
),
(3,
'2008년 글로벌 금융위기의 주요 원인으로 옳은 것은?',
'MULTIPLE_CHOICE',
'{
  "choices": [
    {"text": "유럽부채위기", "correctAnswer": false},
    {"text": "미국의 서브프라임 모기지 부실", "correctAnswer": true},
    {"text": "중국의 위안화 절상", "correctAnswer": false},
    {"text": "일본의 장기불황", "correctAnswer": false}
  ]
}',
'MEDIUM',
'부실 주택담보대출이 증권화되어 전 세계 금융시장으로 확산되며 위기를 촉발했다.',
23,
0.00,
NOW(),
NOW()
);

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
(4,
    '기준금리가 인상되면 일반적으로 대출 금리는 어떻게 될까요?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "오른다", "correctAnswer": true},
         {"text": "내린다", "correctAnswer": false},
         {"text": "그대로다", "correctAnswer": false},
         {"text": "무관하다", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '기준금리는 시중은행 금리의 기준이 되며, 인상되면 대출·예금 금리도 함께 올라가는 경향이 있다.',
    5,
    0.00,
    NOW(),
    NOW()
),
-- 7
(4,
    '은행이 파산하더라도 예금자의 돈을 일정 한도까지 보호해준다. (O/X)',
    'OX',
    '{"correctAnswer": true}',
    'EASY',
    '예금자 보호 제도는 금융기관이 파산하더라도 예금자 1인당 최대 5천만 원까지 보호해주는 안전장치다.',
    7,
    0.00,
    NOW(),
    NOW()
),
-- 8
(4,
    '일반적으로 시장 금리가 오르면 채권 가격은 하락한다. (O/X)',
    'OX',
    '{"correctAnswer": true}',
    'MEDIUM',
    '금리와 채권 가격은 반비례 관계에 있으며, 금리가 상승하면 기존 채권의 가치는 하락한다.',
    8,
    0.00,
    NOW(),
    NOW()
),
-- 10
(4,
    '다음 중 고정금리의 특징으로 적절한 것은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "금리 인상 시 이자가 낮아진다", "correctAnswer": false},
         {"text": "금리 변동에 따라 월 납입액이 달라진다", "correctAnswer": false},
         {"text": "처음부터 끝까지 이자율이 동일하다", "correctAnswer": true},
         {"text": "기준금리와 직접 연동된다", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '고정금리는 약정한 기간 동안 금리가 변하지 않아 금리 상승기에는 유리하다.',
    10,
    0.00,
    NOW(),
    NOW()
),
-- 15
(4,
    '다음 중 적금의 특징으로 적절한 것은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "한 번에 목돈을 맡긴다", "correctAnswer": false},
         {"text": "정기적으로 일정 금액을 납입한다", "correctAnswer": true},
         {"text": "만기 전 자유롭게 출금 가능", "correctAnswer": false},
         {"text": "이자가 없다", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '적금은 목표 금액을 만들기 위해 매달 일정한 금액을 저축하는 방식이다.',
    15,
    0.00,
    NOW(),
    NOW()
),
-- 18
(4,
    '기준금리가 인하되면 일반적으로 소비와 투자는 증가한다. (O/X)',
    'OX',
    '{"correctAnswer": true}',
    'MEDIUM',
    '기준금리가 내려가면 대출이 쉬워지고 이자 부담이 줄어 소비와 투자가 촉진된다.',
    18,
    0.00,
    NOW(),
    NOW()
),
-- 20
(4,
    '소비자 입장에서 체감하는 경제 상황을 가장 잘 반영하는 지표는 무엇인가요?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "명목GDP", "correctAnswer": false},
         {"text": "실질GDP", "correctAnswer": false},
         {"text": "소비자심리지수", "correctAnswer": true},
         {"text": "총생산지수", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '소비자심리지수는 향후 경기, 물가, 가계 재정 상황에 대한 소비자의 기대를 수치로 나타낸다.',
    20,
    0.00,
    NOW(),
    NOW()
),
-- 21
(4,
    '차량 사고 발생 시 운전자와 피해자의 손해를 보상해주는 보험 상품은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "실손의료보험", "correctAnswer": false},
         {"text": "자동차 보험", "correctAnswer": true},
         {"text": "운전자 보험", "correctAnswer": false},
         {"text": "화재보험", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '자동차 보험은 차량 운행 중 발생할 수 있는 재산 피해와 인명 피해를 보장하는 보험으로, 법적으로 의무 가입 대상이다.',
    21,
    0.00,
    NOW(),
    NOW()
),
-- 22
(4,
    '병원 진료나 치료 후 본인이 실제로 지출한 의료비를 보장해주는 보험은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "건강보험", "correctAnswer": false},
         {"text": "생명보험", "correctAnswer": false},
         {"text": "실손의료보험", "correctAnswer": true},
         {"text": "치아보험", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '실손의료보험은 치료 후 본인이 낸 병원비 중 건강보험에서 보장하지 않는 자기부담금 등을 일정 비율 보장해준다.',
    22,
    0.00,
    NOW(),
    NOW()
),
-- 23
(4,
    '피보험자가 사망할 때까지 평생 보장하는 보험은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "정기보험", "correctAnswer": false},
         {"text": "건강보험", "correctAnswer": false},
         {"text": "종신보험", "correctAnswer": true},
         {"text": "실손보험", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '종신보험은 사망 시 유가족에게 사망보험금을 지급하는 보장성 보험으로, 보장기간이 평생 지속된다.',
    23,
    0.00,
    NOW(),
    NOW()
),
-- 24
(4,
    '보험은 예측하지 못한 사고나 질병에 대한 경제적 위험을 대비하기 위한 수단이다. (O/X)',
    'OX',
    '{"correctAnswer": true}',
    'EASY',
    '보험은 불확실한 사고나 질병 등으로 발생할 수 있는 손실에 대비하여, 사전에 위험을 분산하는 중요한 금융 수단이다.',
    24,
    0.00,
    NOW(),
    NOW()
),
-- 25
(4,
    '보험 계약자가 보험사에 일정 기간마다 납부하는 금전은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "환급금", "correctAnswer": false},
         {"text": "공제금", "correctAnswer": false},
         {"text": "보험료", "correctAnswer": true},
         {"text": "해약환급금", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '보험료는 보험 계약자가 보장 혜택을 받기 위해 정기적으로 납부하는 금액이다.',
    25,
    0.00,
    NOW(),
    NOW()
),
-- 26
(4,
    '보험금을 청구할 때 소비자가 직접 부담해야 하는 금액은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "지급보험금", "correctAnswer": false},
         {"text": "납입금액", "correctAnswer": false},
         {"text": "자기부담금", "correctAnswer": true},
         {"text": "보장금", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '자기부담금은 보험금 청구 시 전액 보상 대신 소비자가 일부 비용을 직접 부담하는 구조를 뜻한다.',
    26,
    0.00,
    NOW(),
    NOW()
),
-- 27
(4,
    '보험 계약을 중도에 해지할 경우 돌려받는 금액은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "보험료", "correctAnswer": false},
         {"text": "해지환급금", "correctAnswer": true},
         {"text": "지급보험금", "correctAnswer": false},
         {"text": "보상금", "correctAnswer": false}
       ]
     }',
    'MEDIUM',
    '보험 계약 해지 시 계약자가 받을 수 있는 환급금으로, 납입 기간과 상품 종류에 따라 달라진다.',
    27,
    0.00,
    NOW(),
    NOW()
),
-- 28
(4,
    '일반적으로 보험 가입이 가능한 연령대는 생애주기 전반에 걸쳐 동일하다. (O/X)',
    'OX',
    '{"correctAnswer": false}',
    'EASY',
    '보험 상품에 따라 가입 가능한 연령이 제한되며, 어린이 보험, 성인 보험, 실버 보험 등 상품별로 상이하다.',
    28,
    0.00,
    NOW(),
    NOW()
),
-- 29
(4,
    '일정 기간 동안만 보장을 제공하고, 만기 후 환급금이 없는 보험은?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "종신보험", "correctAnswer": false},
         {"text": "실손보험", "correctAnswer": false},
         {"text": "정기보험", "correctAnswer": true},
         {"text": "변액보험", "correctAnswer": false}
       ]
     }',
    'HARD',
    '정기보험은 일정 기간 사망 보장을 제공하며, 보험료가 저렴하지만 환급금은 없다.',
    29,
    0.00,
    NOW(),
    NOW()
),
-- 30
(4,
    '보험 가입 후 일정 기간 내에 계약을 취소할 수 있는 제도는?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "자동갱신", "correctAnswer": false},
         {"text": "청약 철회", "correctAnswer": true},
         {"text": "연금전환", "correctAnswer": false},
         {"text": "보장 변경", "correctAnswer": false}
       ]
     }',
    'HARD',
    '청약 철회는 보험 계약 후 15일 이내, 혹은 보험증권을 받은 날로부터 15일 이내에 계약을 취소할 수 있는 제도이다.',
    30,
    0.00,
    NOW(),
    NOW()
),
-- 40
(4,
    '매달 일정한 금액으로 반복되는 지출 항목은 무엇인가요?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "식비", "correctAnswer": false},
         {"text": "월세", "correctAnswer": true},
         {"text": "외식비", "correctAnswer": false},
         {"text": "교통비", "correctAnswer": false}
       ]
     }',
    'EASY',
    '고정지출은 월세, 보험료, 통신비처럼 매달 금액이 거의 변하지 않는 지출을 말한다.',
    40,
    0.00,
    NOW(),
    NOW()
),
-- 41
(4,
    '한 달마다 금액이 달라질 수 있는 소비 항목은 무엇인가요?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "관리비", "correctAnswer": false},
         {"text": "대출이자", "correctAnswer": false},
         {"text": "식비", "correctAnswer": true},
         {"text": "정기보험료", "correctAnswer": false}
       ]
     }',
    'EASY',
    '변동지출은 식비, 교통비 등 생활패턴에 따라 금액이 변동되는 지출을 의미한다.',
    41,
    0.00,
    NOW(),
    NOW()
),
-- 42
(4,
    '한 달 동안 사용할 돈의 항목별 사용 계획을 미리 세우는 것을 ‘예산 계획’이라 한다. (O/X)',
    'OX',
    '{"correctAnswer": true}',
    'EASY',
    '예산계획은 수입과 지출을 효율적으로 조절하기 위한 기본적인 재무 습관이다.',
    42,
    0.00,
    NOW(),
    NOW()
),
-- 48
(4,
    '소비자가 상품 구매 후 일정 기간 내에 계약을 취소하고 환불받을 수 있는 권리는?',
    'MULTIPLE_CHOICE',
    '{
       "choices": [
         {"text": "계약보장", "correctAnswer": false},
         {"text": "청약철회", "correctAnswer": true},
         {"text": "자동해지", "correctAnswer": false},
         {"text": "계약철회", "correctAnswer": false}
       ]
     }',
    'HARD',
    '청약철회는 소비자가 단순 변심 등으로 7일 이내 계약을 취소할 수 있도록 보장하는 제도다.',
    48,
    0.00,
    NOW(),
    NOW()
);

