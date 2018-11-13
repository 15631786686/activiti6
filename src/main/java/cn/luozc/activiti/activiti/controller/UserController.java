package cn.luozc.activiti.activiti.controller;

import cn.luozc.activiti.activiti.datasource.DBIdentifier;
import cn.luozc.activiti.activiti.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView index() {
        DBIdentifier.setProjectCode("activiti2");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new DynamicDataSource());

        Map<String, Object> map = jdbcTemplate.queryForMap("select *from sys_user");
        System.out.println(map);
        return new ModelAndView("/page/login/login");
    }


}
