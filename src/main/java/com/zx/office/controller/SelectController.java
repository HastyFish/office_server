package com.zx.office.controller;

import com.zx.office.entity.Clazz;
import com.zx.office.entity.College;
import com.zx.office.entity.Student;
import com.zx.office.service.ClazzServiceImpl;
import com.zx.office.service.CollegeServiceImpl;
import com.zx.office.service.ProfessionalServiceImpl;
import com.zx.office.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SelectController {

    @Autowired
    private CollegeServiceImpl collegeService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private ClazzServiceImpl clazzService;

    @GetMapping("/selectCollege")
    public List<College> selectCollege(){
        return collegeService.selectCollege();
    }

    @GetMapping("/selectAllClazz")
    public List<Clazz> selectAllClazz(String professionalId){
        return clazzService.selectAllClazz(professionalId);
    }

    @GetMapping("/selectStudent")
    public List<Student> selectAllStudent(String clazzId){
        System.out.println(clazzId);
        return studentService.selectAllStudent(clazzId);
    }
}
