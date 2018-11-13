package cn.luozc.activiti.activiti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivitiApplication {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiApplication.class);
    
    public static void main(String[] args) {
        logger.info("测试日志");
        
        SpringApplication.run(ActivitiApplication.class, args);
    }
}
