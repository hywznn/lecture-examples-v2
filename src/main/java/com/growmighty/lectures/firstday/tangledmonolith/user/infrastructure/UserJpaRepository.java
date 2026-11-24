package com.growmighty.lectures.firstday.tangledmonolith.user.infrastructure;

import com.growmighty.lectures.firstday.tangledmonolith.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
