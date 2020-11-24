package solution.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import solution.dto.UserListResponseDto;
import solution.mapper.UserMapper;
import solution.model.User;
import solution.service.UserService;
import solution.service.impl.ApiServiceImpl;

@Controller
public class UserController {
    private final ApiServiceImpl apiService;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(ApiServiceImpl apiService,
                          UserService userService, UserMapper userMapper) {
        this.apiService = apiService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public String getUserInfo(ModelMap model) {
        UserListResponseDto userListResponseDto = apiService.getUserData();
        List<User> userList =
                userListResponseDto.getResults().stream()
                        .map(userMapper::toUser)
                        .collect(Collectors.toList());
        userService.save(userList);
        model.addAttribute("users", userList);
        return "userInfo";
    }

    @GetMapping("/details")
    public String demo(ModelMap model, @RequestParam Long id) {
        User user = userService.getById(id).orElseThrow();
        model.addAttribute("user", user);
        return "details";
    }
}
