package com.lagou.edu.factory;

import com.lagou.edu.annotation.Autoware;
import com.lagou.edu.annotation.Service;
import com.lagou.edu.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service("transactionProxyFactory")
public class TransactionProxyFactory {

    @Autoware("transactionManager")
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Object getProxy(Object target) {
       return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    transactionManager.startTransaction();
                    result = method.invoke(target, args);
                    transactionManager.commit();
                }catch (Exception e) {
                    e.printStackTrace();
                    transactionManager.rollBack();
                    throw e;
                }
                return result;
        }});
    }
}
