package com.fangyx.exo.pojo.wx;

import lombok.Data;

import java.util.Map;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/9/24 22:55
 * @UpdateUser:
 * @UpdateDate: 2019/9/24 22:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Data
public class WeChatMessageVo {
    private String touser;//用户openid
    private String template_id;//模版id
    private String page = "pages/logs/logs";//默认跳到小程序首页
    private String form_id;//收集到的用户formid
    //    private String emphasis_keyword = "keyword1.DATA";//放大那个推送字段
    private Map<String, TemplateDataVo> data;//推送文字
}
