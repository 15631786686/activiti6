package cn.luozc.activiti.activiti.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@Entity//声明类为实体或表。
@Table(name="sys_user")//声明表名。
@Getter
@Setter
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition="varchar(20) COMMENT '用户名'")
    private String username;
    @Column(columnDefinition="varchar(20) COMMENT '手机号'")
    private String telephone;
    @Column(columnDefinition="varchar(20) COMMENT '邮箱'")
    private String mail;
    @Column(columnDefinition="varchar(50) COMMENT '密码'")
    private String password;
    @Column(columnDefinition="varchar(20) COMMENT '是否启用'")
    private Integer isEnabled;
    @Column(columnDefinition="varchar(2000) COMMENT '备注'")
    private String remark;
    @Column(columnDefinition="varchar(10) COMMENT '性别'")
    private String sex;
    @Column(columnDefinition="datetime COMMENT '创建时间'")
    private String creationTime;

}