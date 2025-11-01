package com.igemoney.igemoney_BE.costume;


import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.costume.dto.CostumeItem;
import com.igemoney.igemoney_BE.costume.dto.CostumeListResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CostumeService {

    private final UserRepository userRepository;

    @Value("${app.costume.public-url-prefix:/costumes/}")
    private String publicPrefix;

    @Transactional(readOnly = true)
    public CostumeListResponse getCostumeList(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        Long wornId = user.getWornCostumeId();

        List<CostumeItem> items = Arrays.stream(CostumeType.values())
            .map(ct -> {
                Long ctId = ct.getId();
                boolean isWorn = wornId.equals(ct.getId());
                String fileName;
                if (ctId > 0L){
                    fileName = ct.getOffFileUrl();
                } else {
                    fileName = "아무것도 안입은 콩식이 이미지";
                }
                return new CostumeItem(ctId, isWorn, publicPrefix+fileName);
            })
            .toList();
        return new CostumeListResponse(items);
    }

    public void wearCostume(Long userId, Long costumeId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        CostumeType.fromId(costumeId); // costumdId값 유효성 검증용 호출
        user.updateWornCostumeId(costumeId);
    }
}
