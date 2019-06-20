package com.zx.office.service;

import com.zx.office.dao.StudentDao;
import com.zx.office.entity.Student;
import com.zx.office.tools.ListProcess;
import com.zx.office.tools.TimeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public List<Student> selectAllStudent(String clazzId){
        return studentDao.selectAllStudent(clazzId);
    }

    //添加学生, 入学年份(4)+专业(4)+编号(2)
    @Transactional
    public int addStudent(String studentName, String studentSex, String clazzId){
        Student student = new Student();
        String enrollment = TimeProcess.getYear();
        String professionalId = clazzId.substring(0,clazzId.length()-4);
        List<String> studentIds = studentDao.selectSid(clazzId);
        int studentId = ListProcess.FirstMissVal(studentIds);
        String studentIdToString;
        if (studentId == 0)
            studentIdToString = "01";
        else studentIdToString = studentId >= 10 ? String.valueOf(studentId) : "0" + studentId;
        String sId = enrollment + professionalId + studentIdToString;
        System.out.println(sId);
        student.setClazzId(clazzId);
        student.setStudentEnrollment(enrollment);
        student.setStudentName(studentName);
        student.setStudentSex(studentSex);
        student.setStudentId(sId);
        return studentDao.addStudent(student);
    }
}
