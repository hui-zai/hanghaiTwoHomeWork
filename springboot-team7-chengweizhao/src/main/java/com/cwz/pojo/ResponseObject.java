package com.cwz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.pojo
 * @ClassName: ResponseObject
 * @Author: 程伟钊
 * @Description: 响应结果
 * @Date: 2020/1/1 22:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    private String msg;
    private String code;
    private Object object;
}
