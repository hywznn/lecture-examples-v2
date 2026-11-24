package com.growmighty.lectures.firstday.tangledmonolith.user.application;

import com.growmighty.lectures.firstday.tangledmonolith.user.domain.User;
import com.growmighty.lectures.firstday.tangledmonolith.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다. userId=" + userId));
    }
}
