package com.igemoney.igemoney_BE.costume;


import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.costume.dto.CostumeItem;
import com.igemoney.igemoney_BE.costume.dto.CostumeListResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CostumeService {

    private final UserRepository userRepository;

    public CostumeListResponse getCostumeList(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        Long wornId = user.getWornCostumeId();

        List<CostumeItem> items = Arrays.stream(CostumeType.values())
            .map(costumeType -> {
                boolean isWorn = wornId.equals(costumeType.getId());
                String fileName = cost
            })
    }
}
