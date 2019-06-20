package com.zx.office.controller;

import com.zx.office.entity.Clazz;
import com.zx.office.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InsertController {
    @Autowired
    private ClazzServiceImpl clazzService;

    @GetMapping("/addClazz")
    public int addClazz(String clazzName, String guideName){
        Clazz clazz = new Clazz();
        clazz.setClazzName(clazzName);
        return clazzService.addClazz(clazz, clazzName, guideName);
    }
}
