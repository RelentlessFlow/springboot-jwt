package com.yzq.springbootjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.yzq.springbootjwt.annotation.UserLoginToken;
import com.yzq.springbootjwt.entity.User;
import com.yzq.springbootjwt.service.TokenService;
import com.yzq.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public Object login( User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","Login failed, user does not exist.");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","Login failed, incorrect password.");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    
    @UserLoginToken
    @GetMapping("/hello-world")
    public String getMessage(){
        return "Passed the verification.";
    }
}
