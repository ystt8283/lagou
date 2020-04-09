package com.lagou.edu.servlet;

import com.lagou.edu.factory.AnnotationBeanFactory;
import com.lagou.edu.pojo.Result;
import com.lagou.edu.service.TransferService;
import com.lagou.edu.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置请求体的字符编码
        req.setCharacterEncoding("UTF-8");

        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");
        int money = Integer.parseInt(moneyStr);

        Result result = new Result();
        try {

            TransferService transferService = (TransferService) AnnotationBeanFactory.getInstance().getBean("transferService");
            transferService.transfer(fromCardNo,toCardNo,money);
            result.setStatus("200");
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 响应
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(JsonUtils.object2Json(result));
        System.out.println("拦截成功");
    }
}
