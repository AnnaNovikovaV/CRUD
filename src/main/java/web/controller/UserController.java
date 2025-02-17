package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService = new UserServiceImpl();


    @GetMapping
    public String printUsers(Model model) {
        model.addAttribute("users", userService.printUsers());
        return "redirect:/user";
    }

//
//    @GetMapping("/new")
//    public String newUser(@RequestParam(value = "name", required = false) String name,
//                          @RequestParam(value = "lastName", required = false) String lastName,
//                          @RequestParam(value = "id", required = false) Long id, Model model) {
//        model.addAttribute("user", userService.createUser(new User(id, name, lastName)));
//        return "redirect:/users";
//    }
////
////    @GetMapping("/update")
////    public String updateUser(@RequestParam(value = "id", required = false) Integer id,
////                             @RequestParam(value = "name", required = false) String name,
////                             @RequestParam(value = "lastName", required = false) String lastName,
////                             Model model) {
////        model.addAttribute("user", new User(id, name, lastName));
////        return "redirect:/users";
////    }
////
////    public String deleteUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
////        model.addAttribute("user", new User(id));
////        return "redirect:/users";
////    }
}
