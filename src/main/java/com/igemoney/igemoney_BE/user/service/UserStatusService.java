package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.user.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserStatusService {

    private final UserStatusRepository userStatusRepository;


}
