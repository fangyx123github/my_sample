package com.fangyx.exo.web;

import com.fangyx.exo.pojo.UserPoJo;
import com.fangyx.exo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/13 23:03
 * @UpdateUser:
 * @UpdateDate: 2019/7/13 23:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    //跳转登录页
    @RequestMapping("/index")
    public String show(Model model){
        model.addAttribute("user",new UserPoJo());
        return "pagehtml/login";
    }

    @PostMapping("/register")
    public String register(UserPoJo user) throws Exception {
        int su = userService.save(user);
        if(su == 0 ){
            return "注册失败，请联系管理员";
        }
        return "pagehtml/index";
    }

    @RequestMapping("/login")
    public String login(UserPoJo user, HttpServletRequest request) throws Exception{
        String userName = user.getUserName();
        String password = user.getPassword();
        UserPoJo userPoJo = userService.login(userName, password);
        if(ObjectUtils.isEmpty(userPoJo)){
            return "用户名或密码错误";
        }else{
            request.getSession().setAttribute("session_user",userPoJo);
            return "redirect:/user/main";
        }
    }

    @RequestMapping("/main")
    public String  showIndex(){
        return "pagehtml/index";
    }

}
