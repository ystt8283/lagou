package com.lagou.edu.test;

import com.lagou.edu.annotation.Service;
import com.lagou.edu.factory.AnnotationBeanFactory;
import com.lagou.edu.factory.BeanFactory;
import com.lagou.edu.factory.TransactionProxyFactory;
import com.lagou.edu.service.TransferService;
import com.lagou.edu.service.impl.TransferServiceImpl;
import com.lagou.edu.utils.FetchClassesUtils;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class TestService {

    /**
     * xml解析的方式
     * @throws Exception
     */
    @Test
    public void testByXML() throws Exception {

//        TransferService transferService = new TransferServiceImpl();
        TransactionProxyFactory transactionProxyFactory = (TransactionProxyFactory) BeanFactory.getBean("transactionProxyFactory");
        TransferService transferService = (TransferService) transactionProxyFactory.getProxy(BeanFactory.getBean("transferService"));
//        TransferService transferService = (TransferService) BeanFactory.getBean("transferService");
        transferService.transfer("11111122","22222211", 100);
    }


    /**
     * 注解方式
     * @throws Exception
     */
    @Test
    public void testByAnnotation() throws Exception {


        AnnotationBeanFactory annotationBeanFactory = new AnnotationBeanFactory();
        annotationBeanFactory.init("com.lagou.edu");
        TransferService transferService = (TransferService) annotationBeanFactory.getBean("transferService");
        transferService.transfer("11111122","22222211", 100);
    }
}
