package com.fangyx.exo.interceptor;

import com.fangyx.exo.pojo.UserPoJo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/16 0:05
 * @UpdateUser:
 * @UpdateDate: 2019/7/16 0:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

   /*
    * @author:Fangyx
    * @date:2019/7/31
    * @description: 进入controller层之前拦截请求
    *               返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
    *               Object obj:表示被拦的请求的目标对象（controller中方法）
    * @params:
    * @return:
    * @throws
    */
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       //请求进入这个拦截器
       HttpSession session = request.getSession();
       UserPoJo user = (UserPoJo) session.getAttribute("session_user");
       if(user == null){       //判断session中有没有user信息
           response.sendRedirect(request.getContextPath() +"/user/index");     //没有user信息的话进行路由重定向
           return false;
       }
       return true;        //有的话就继续操作
   }
    /*
     * @author:Fangyx
     * @date:2019/7/31
     * @description:处理请求完成后视图渲染之前的处理操作通过ModelAndView参数改变显示的视图，或发往视图的方法
     * @params:
     * @return:
     * @throws
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了postHandle方法");
    }
    /*
     * @author:Fangyx
     * @date:2019/7/31
     * @description: 视图渲染之后的操作
     * @params:
     * @return:
     * @throws
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        System.out.println("执行到了afterCompletion方法");
    }
}
