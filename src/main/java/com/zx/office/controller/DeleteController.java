package com.zx.office.controller;

import com.zx.office.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DeleteController {
    @Autowired
    private ClazzServiceImpl clazzService;

    @GetMapping("/deleteByClazzId")
    public int deleteByClazzId(String clazzId){
        return clazzService.deleteByClazzId(clazzId);
    }
}
