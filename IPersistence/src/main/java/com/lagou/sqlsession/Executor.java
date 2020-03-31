package com.lagou.sqlsession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStateMent;

import java.util.List;

public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStateMent mappedStatement, Object... params) throws Exception;
}
