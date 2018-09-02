package com.springboot.web;

import com.springboot.entity.Student;
import com.springboot.mapper.StudentMapper;
import com.springboot.service.StudentService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
   @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("/hello")
    public ModelAndView hello(Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("list",studentMapper.findAll());
        model.addAttribute("name","thymeleaf");
        mav.setViewName("/index");
        return mav;
    }
    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/add");
        return mav;
    }
    @RequestMapping("insert")
    public String insert(Student student){
        studentMapper.insert(student);
        return "redirect:hello";
    }
    @RequestMapping("/update")
    public String update(Student student){
        System.out.println(student);
        studentMapper.update(student);
        return "redirect:hello";
    }
    @RequestMapping("/delete")
    public String delete(Student student){
        studentMapper.delete(student.getSid());
        return "redirect:hello";
    }
    @RequestMapping("/findOne")
    public ModelAndView findOne(Student student,Model model){
        ModelAndView mav=new ModelAndView();
        model.addAttribute("find",studentMapper.findOne(student.getSid()));
        mav.setViewName("add");
        return mav;
    }
}
