package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStateMent;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {
    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");

        List<Element> list = rootElement.selectNodes("//select");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("parameterType");
            String sqlText = element.getTextTrim();
            MappedStateMent mappedStatement = new MappedStateMent();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(paramterType);
            mappedStatement.setSql(sqlText);
            //作业添加命令类型区分  增删改查
            mappedStatement.setCommandType("SELECT");
            String key = namespace+"."+id;
            configuration.getMappedStateMentMap().put(key,mappedStatement);

        }

        list = rootElement.selectNodes("//update");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("parameterType");
            String sqlText = element.getTextTrim();
            MappedStateMent mappedStatement = new MappedStateMent();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(paramterType);
            mappedStatement.setSql(sqlText);
            //作业添加命令类型区分  增删改查
            mappedStatement.setCommandType("UPDATE");
            String key = namespace+"."+id;
            configuration.getMappedStateMentMap().put(key,mappedStatement);

        }

        list = rootElement.selectNodes("//insert");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("parameterType");
            String sqlText = element.getTextTrim();
            MappedStateMent mappedStatement = new MappedStateMent();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(paramterType);
            mappedStatement.setSql(sqlText);
            //作业添加命令类型区分  增删改查
            mappedStatement.setCommandType("INSERT");
            String key = namespace+"."+id;
            configuration.getMappedStateMentMap().put(key,mappedStatement);

        }

    }

}
