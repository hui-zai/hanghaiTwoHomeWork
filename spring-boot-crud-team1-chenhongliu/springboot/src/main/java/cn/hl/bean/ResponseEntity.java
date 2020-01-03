package cn.hl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity {
    private String msg; //返回信息
    private String code; //状态码
    private Object obj; //返回对象数据
}
