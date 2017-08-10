package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

/**
 * Created by 01083446 on 2017/8/9.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ModelAndView findOne(@PathVariable String id) {
        ModelAndView result = new ModelAndView();
        result.addObject(userService.findOne(id));
        return result;
    }

    @PostMapping()
    public ModelAndView create(@RequestBody User user) {
        ModelAndView result = new ModelAndView();
        result.addObject(userService.addOne(user));
        return result;
    }

}
