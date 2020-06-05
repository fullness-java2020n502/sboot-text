package com.fullnesssboot2.text.controller;

import com.fullnesssboot2.text.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("pathval")
@Controller
public class PathValController {
    @GetMapping("val/{no}")
    public String home(@PathVariable Integer no){
        System.out.println("no:"+no);
        if(no == 3) throw new BusinessException("ビジネスエラー");
        return "pathval";
    }

    @ExceptionHandler(BusinessException.class)
    public ModelAndView catchException(BusinessException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
