package com.fangyx.exo.pojo.user;

import lombok.Data;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/7/13 22:41
 * @UpdateUser:
 * @UpdateDate: 2019/7/13 22:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Data
public class UserPoJo {
    private Integer id;
    private String userName;
    private String nick;
    private String password;
    private String birthday;
    private Integer gender;
    private String imagePath;
    private Integer status;
}
