package cn.luozc.activiti.activiti.common;

import javax.sql.DataSource;

public class GlobalData {
    public  DataSource dataSource =null;
    public  DataSource getDataSource() {
        return this.dataSource;
    }
    public static void SetDataSource(DataSource dataSource) {

    }
}
