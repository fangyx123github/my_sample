package com.fangyx.exo.web.wx;

import com.fangyx.exo.service.wx.WeChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/9/24 23:18
 * @UpdateUser:
 * @UpdateDate: 2019/9/24 23:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Controller
@RequestMapping("user")
public class WeChatMessageController {

    @Autowired
    private WeChatMessageService weChatMessageService;

    @GetMapping("/wx/pushMessage")
    public String sendMessage(String openid, String formid){
        return weChatMessageService.sendMessage(openid, formid);
    }
}
