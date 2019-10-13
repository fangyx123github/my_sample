package com.fangyx.exo.service.user;

import com.fangyx.exo.mapper.user.UserMapper;
import com.fangyx.exo.pojo.user.UserPoJo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/13 22:53
 * @UpdateUser:
 * @UpdateDate: 2019/7/13 22:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /*
     * @author:Fangyx
     * @date:2019/7/13
     * @description: 注册
     * @params: 用户对象
     * @return:
     * @throws
     */
    public int save(UserPoJo user) throws Exception{
        user.setStatus(1);
        int result = userMapper.insert(user);
        return result;
    }

    /*
     * @author:Fangyx
     * @date:2019/7/13
     * @description: 登录
     * @params: id
     * @return:
     * @throws
     */
    public UserPoJo getEntity(Integer id) throws Exception{
        UserPoJo entity = userMapper.getUserById(id);
        return entity;
    }

    public UserPoJo login(String userName, String password) throws Exception{
        UserPoJo user = userMapper.login(userName,password);
        return user;
    }

}
