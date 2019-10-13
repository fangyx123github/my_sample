package com.fangyx.exo.pojo.wx;

import lombok.Data;

/**
 * @Author: Fangyx
 * @Description:
 * @CreateDate: 2019/9/24 22:54
 * @UpdateUser:
 * @UpdateDate: 2019/9/24 22:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 **/
@Data
public class TemplateDataVo {
    //字段值例如：keyword1：订单类型，keyword2：下单金额，keyword3：配送地址，keyword4：取件地址，keyword5备注
    private String value;//依次排下去
//    private String color;//字段颜色（微信官方已废弃，设置没有效果）
}
