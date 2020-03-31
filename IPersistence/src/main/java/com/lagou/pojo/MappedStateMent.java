package com.lagou.pojo;

public class MappedStateMent {

    /**
     * 该类存储4部分信息
     * id
     * 返回值类型 resultType
     * 参数类型  parameterType
     * sql语句
     */

    private String id;
    private String resultType;
    private String parameterType;
    private String sql;

    //为作业添加
    private String commandType;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
