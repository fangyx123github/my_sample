package com.fangyx.exo.service.wx;

import com.alibaba.fastjson.JSONObject;
import com.fangyx.exo.pojo.wx.TemplateDataVo;
import com.fangyx.exo.pojo.wx.WeChatMessageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/9/24 22:56
 * @UpdateUser:
 * @UpdateDate: 2019/9/24 22:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Slf4j
@Service
public class WeChatMessageService {

    private static final String APP_ID="wx5c9551b8b428a236";
    private static final String APP_SECRET="7d42f8973a00155a821ef545a1747bee";
    private static final String TEMPLATE_ID="oNRrmXHIXQLrN4N2N_TzYJntO4MQbfBzG1TlvoELfqQ";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;
    /**
     *
     * @param openid 用户openid
     * @param formId 表单ID formId有效期为7天，一个formId只能发送一次通知，发完就不能再用了，formId是发送推送信息的必要条件。
     * @return
     */
    public String sendMessage(String openid, String formId) {
        String access_token = null;
        ResponseEntity<String> responseEntity = null;
        try {
            LocalDateTime nowDate = LocalDateTime.now(ZoneOffset.of("+8"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String date = nowDate.format(dtf);
            // {与模板字段一一对应}
            String[] keywords = new String[]{"王哲", "你有一条待确认的医废信息，请及时处理","待办通知",date};
            //如果access_token为空则从新获取
            if (StringUtils.isEmpty(access_token)) {
                access_token = getAccess_token();
            }
            String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + access_token;
            log.info("===========发送消息的接口地址:" + url+"==============");
            //拼接推送模板
            WeChatMessageVo weChatMessageVo = new WeChatMessageVo();
            weChatMessageVo.setTouser(openid);
            weChatMessageVo.setForm_id(formId);
            weChatMessageVo.setTemplate_id(TEMPLATE_ID);
            Map<String, TemplateDataVo> map = new HashMap<>();
            //封装数据
            if (keywords.length > 0) {
                for (int i = 1; i <= keywords.length; i++) {
                    TemplateDataVo keyword = new TemplateDataVo();
                    keyword.setValue(keywords[i-1]);
                    map.put("keyword" + i, keyword);
                }
                weChatMessageVo.setData(map);
            } else {
                log.error("keywords长度为空");
                return null;
            }
            if (restTemplate == null) {
                restTemplate = new RestTemplate();
            }
            responseEntity =restTemplate.postForEntity(url, weChatMessageVo, String.class);
            log.info("=========小程序推送结果={}", responseEntity.getBody()+"===========");
        } catch (RestClientException re) {
            log.error("远程访问出错了!!!");
            re.printStackTrace();
        }
        return responseEntity.getBody();
    }

    /*
     * 获取access_token
     * appid和appsecret到小程序后台获取，当然也可以让小程序开发人员给你传过来
     * */
    public String getAccess_token() {
        String accessToken = null;
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;
            log.info("==========获取access_token的接口地址:" + url+"===========");
            if (restTemplate == null) {
                restTemplate = new RestTemplate();
            }
            String json = restTemplate.getForObject(url, String.class);
            JSONObject myJson = JSONObject.parseObject(json);
            accessToken = myJson.get("access_token").toString();
        } catch (RestClientException re) {
            log.error("远程访问出错了!!!");
            re.printStackTrace();
        } catch (IllegalStateException ie){
            log.error("==========远程连接失败=======");
            ie.printStackTrace();
        }
        log.info("access_token:" + accessToken);
        return accessToken;
    }

    /*public static void main(String[] args) {
        WeChatMessageService ws = new WeChatMessageService();
        ws.sendMessage("oYREw5fP0hB69EDbCV7R3fTtUab0","f15006126c6944d09a295bc0faed1cf5");
    }*/
}
