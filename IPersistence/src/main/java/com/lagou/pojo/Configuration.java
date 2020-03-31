package com.lagou.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private DataSource dataSource;

    /**
     * key stateMentid
     */
    private Map<String, MappedStateMent> mappedStateMentMap = new HashMap<String, MappedStateMent>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStateMent> getMappedStateMentMap() {
        return mappedStateMentMap;
    }

    public void setMappedStateMentMap(Map<String, MappedStateMent> mappedStateMentMap) {
        this.mappedStateMentMap = mappedStateMentMap;
    }
}
