package com.growmighty.lectures.firstday.tangledmonolith.user.presentation;

import com.growmighty.lectures.firstday.tangledmonolith.user.application.UserService;
import com.growmighty.lectures.firstday.tangledmonolith.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable("userId") Long userId){
        User user = userService.getUser(userId);

        return new UserResponse(user.getId(), user.getName());
    }
}
