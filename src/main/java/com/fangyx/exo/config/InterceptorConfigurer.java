package com.fangyx.exo.config;

import com.fangyx.exo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/8/3 11:22
 * @UpdateUser:
 * @UpdateDate: 2019/8/3 11:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //登录拦截的管理器
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);     //拦截的对象会进入这个类中进行判断
        List<String> list = new ArrayList<String>();
        list.add("/user/login");
        list.add("/user/index");
        list.add("/user/register");
        list.add("/user/wx/pushMessage");
        // addPathPatterns 用于添加拦截规则+
        // excludePathPatterns 用户排除拦截,要连着写，要不然不生效
        registration.addPathPatterns("/user/**").excludePathPatterns(list);       //添加不拦截路径
    }
    /*
     * @author:Fangyx
     * @date:2019/8/2
     * @description: 添加不拦截静态
     * @params:
     * @return:
     * @throws
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }

}
