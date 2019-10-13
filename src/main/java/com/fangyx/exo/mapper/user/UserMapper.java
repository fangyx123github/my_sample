package com.fangyx.exo.mapper.user;

import com.fangyx.exo.pojo.user.UserPoJo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/13 22:48
 * @UpdateUser:
 * @UpdateDate: 2019/7/13 22:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Mapper
@Repository
public interface UserMapper {
    /*
     * @author:Fangyx
     * @date:2019/7/13
     * @description: 根据id查询用户
     * @params: id
     * @return: UserPOJO
     * @throws
     */
    UserPoJo getUserById(int id) throws Exception;

    /*
     * @author:Fangyx
     * @date:2019/7/13
     * @description: 插入数据
     * @params:  用户对象
     * @return: 行数
     * @throws
     */
    int insert(@Param("user") UserPoJo user) throws Exception;
    /*
     * @author:Fangyx
     * @date:2019/7/31
     * @description: 登录
     * @params:
     * @return:
     * @throws
     */
    UserPoJo login(@Param("userName") String userName, @Param("password") String password) throws Exception;

}
