package cn.hl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condition {
    private String username;
    private String sex;
    private Integer pageNo;
    private Integer pageSize;
}
