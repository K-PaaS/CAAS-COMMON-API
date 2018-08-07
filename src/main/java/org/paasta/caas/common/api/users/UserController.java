package org.paasta.caas.common.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Controller 클래스
 *
 * @author REX
 * @version 1.0
 * @since 2018.08.02
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    /**
     * Gets user list.
     *
     * @return the user list
     */
    @GetMapping
    List<User> getUserList() {
        return userService.getUserList();
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping(value = "/{id:.+}")
    User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    @PutMapping
    User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * Delete user string.
     *
     * @param user the user
     * @return the string
     */
    @DeleteMapping
    String deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}























