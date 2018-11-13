package cn.luozc.activiti.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from sys_user");
        System.out.println(map);
        return new ModelAndView("/page/login/login");
    }


}
