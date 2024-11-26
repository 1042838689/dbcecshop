package com.example.dbcec.controller;


import com.example.dbcec.entity.User;
import com.example.dbcec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public String submitData(
            @RequestParam("param1") String param1,
            @RequestParam("param2") int param2,
            @RequestParam("param3") boolean param3) {

        // 这里可以添加处理参数的逻辑
        return "接收到参数：param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("seach")
    public List<User> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }


    @GetMapping("list")
    public HashMap<String, Object> getUsersByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//        int offset = (pageNum - 1) * pageSize;
        System.out.println("总数:"+userService.selecttotal());
        int total=userService.selecttotal();
        List<User> user=userService.selectUserByPage(pageNum, pageSize);
        System.out.println("111:"+user.toString());
//        for (User u : user) {
//            System.out.println("name"+u.getName());
//        }
//        user.foreach(System.out::println())
        HashMap<String, Object> Sites = new HashMap<>();
//        Sites.put("count",total);
        Sites.put("page",pageNum);
        Sites.put("total",(total/pageSize));
        Sites.put("data",user);
        return Sites;

    }
}
