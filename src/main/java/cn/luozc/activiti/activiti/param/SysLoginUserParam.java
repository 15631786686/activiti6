package cn.luozc.activiti.activiti.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SysLoginUserParam {


    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, min = 3, message = "账号长度需要在3-20个字之间")
    private String username;


    @NotBlank(message = "密码不能为空")
    private String password;

}
