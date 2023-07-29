package com.ydl.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }
}
