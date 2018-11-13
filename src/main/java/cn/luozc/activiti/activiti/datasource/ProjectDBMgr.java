package cn.luozc.activiti.activiti.datasource;

import java.util.HashMap;
import java.util.Map;
/**
 * 项目数据库管理。提供根据项目编码查询数据库名称和IP的接口。
 * @author elon
 * @version 2018年2月25日
 */
public class ProjectDBMgr {
    /**
     * 保存项目编码与数据名称的映射关系。这里是硬编码，实际开发中这个关系数据可以保存到redis缓存中；
     * 新增一个项目或者删除一个项目只需要更新缓存。到时这个类的接口只需要修改为从缓存拿数据。
     */
    private Map<String, String> dbNameMap = new HashMap<String, String>();
    /**
     * 保存项目编码与数据库IP的映射关系。
     */
    private Map<String, String> dbIPMap = new HashMap<String, String>();
    /**
     * 保存项目编码与数据库用户名的映射关系。
     */
    private Map<String, String> dbUserNameMap = new HashMap<String, String>();
    /**
     * 保存项目编码与数据库密码的映射关系。
     */
    private Map<String, String> dbPasswordMap = new HashMap<String, String>();
    private ProjectDBMgr() {
        dbNameMap.put("activiti2", "activiti2");
        dbIPMap.put("activiti2", "119.29.119.221");
        dbUserNameMap.put("activiti2","lzc");
        dbPasswordMap.put("activiti2","luozc1993.");
        dbNameMap.put("activiti", "activiti");
        dbIPMap.put("activiti", "119.29.119.221");
        dbUserNameMap.put("activiti","lzc");
        dbPasswordMap.put("activiti","luozc1993.");

    }
    public static ProjectDBMgr instance() {
        return ProjectDBMgrBuilder.instance;
    }
    // 实际开发中改为从缓存获取
    public String getDBName(String projectCode) {
        if (dbNameMap.containsKey(projectCode)) {
            return dbNameMap.get(projectCode);
        }
        return "";
    }
    //实际开发中改为从缓存中获取
    public String getDBIP(String projectCode) {
        if (dbIPMap.containsKey(projectCode)) {
            return dbIPMap.get(projectCode);
        }
        return "";
    }
    public String getDBUserName(String projectCode) {
        if (dbUserNameMap.containsKey(projectCode)) {
            return dbUserNameMap.get(projectCode);
        }
        return "";
    }
    public String getDBPassword(String projectCode) {
        if (dbPasswordMap.containsKey(projectCode)) {
            return dbPasswordMap.get(projectCode);
        }
        return "";
    }
    private static class ProjectDBMgrBuilder {
        private static ProjectDBMgr instance = new ProjectDBMgr();
    }
}
