package com.leonardo.springmvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @RequestMapping("/showForm")
    public ModelAndView showForm() {
        Student student = new Student();
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student-form");
        mv.addObject("student", student);
        return mv;
    }

    @RequestMapping("/processStudentForm")
    public ModelAndView processStudentForm(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);

        if (bindingResult.hasErrors()) {
            mv.setViewName("student-form");
        } else {
            mv.setViewName("student-confirmation");
        }

        return mv;
    } 

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
