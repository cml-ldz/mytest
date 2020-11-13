package com.yaorange.control;

import com.github.pagehelper.PageInfo;
import com.yaorange.entity.User;
import com.yaorange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public List<User> showAll() {
        return userService.findAll();
    }

    @GetMapping("/listByPage/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<User>> listByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<User> page = userService.findByPage(pageNum,pageSize);
        if(page != null){
            //请求成功响应数据
            return ResponseEntity.ok(page);
        }
        //响应状态码
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user){
        user.setCreated(new Date());
        user.setUpdated(new Date());
        Integer rows = userService.save(user);
        if(rows > 0){
            //请求成功响应数据
            return ResponseEntity.ok("新增成功");
        }
        //响应自定义的状态码
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user){
        user.setUpdated(new Date());
        Integer rows = userService.update(user);
        if(rows > 0){
            //请求成功响应数据
            return ResponseEntity.ok("update ok");
        }
        //响应自定义的状态码
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Integer rows = userService.deleteById(id);
        if(rows > 0){
            //请求成功响应数据
            return ResponseEntity.ok("删除成功");
        }
        //响应自定义的状态码
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
