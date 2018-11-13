package cn.luozc.activiti.activiti.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity//声明类为实体或表。
@Table(name="sys_datasource")//声明表名。
@Getter
@Setter
public class SysDataSource implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition="varchar(100) COMMENT '数据库名称'")
    private String dataBase;
    @Column(columnDefinition="varchar(20) COMMENT '数据库ip'")
    private String ip;
    @Column(columnDefinition="varchar(20) COMMENT '数据库账号'")
    private String username;
    @Column(columnDefinition="varchar(50) COMMENT '数据库密码'")
    private String password;
    @Column(columnDefinition="varchar(20) COMMENT '是否启用'")
    private Integer isEnabled;
    @Column(columnDefinition="varchar(2000) COMMENT '备注'")
    private String sex;
    @Column(columnDefinition="datetime COMMENT '创建时间'")
    private String creationTime;

}