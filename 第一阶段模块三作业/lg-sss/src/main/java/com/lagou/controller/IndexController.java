package com.lagou.controller;

import com.lagou.dao.ResumeDao;
import com.lagou.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private ResumeDao resumeDao;

    @RequestMapping("/index")
    public String index() {
        System.out.println("jjjjjj");
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAll(Map<String, Object> map) {
        List<Resume> all = resumeDao.findAll();
        for (Resume resume : all) {
            System.out.println(resume);
        }
        map.put("listAll", all);
//        request.setAttribute("list", all);
        return "list";
    }
}
