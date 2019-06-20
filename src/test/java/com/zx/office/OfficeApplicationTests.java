package com.zx.office;

import com.zx.office.entity.*;
import com.zx.office.service.*;
import com.zx.office.tools.ListProcess;
import com.zx.office.tools.TimeProcess;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeApplicationTests {
    @Autowired
    private ProfessionalServiceImpl professionalService;

    @Autowired
    private CollegeServiceImpl collegeService;

    @Autowired
    private GuideServiceImpl guideService;

    @Autowired
    private ClazzServiceImpl clazzService;

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void testCollegeService(){
        //增设学院
        /*
        int test1 = collegeService.addCollege("人工智能学院");
        int test2 = collegeService.addCollege("艺术设计学院");
         */

        //查询学院名字
        /*
        if (collegeService.selectCollegeName() == null) throw new AssertionError();
        else{
            for (var x : collegeService.selectCollegeName())
                System.out.println(x);
        }
         */

        //根据学院名字,查询学院所有专业名字
        /*
        List<Professional> list = collegeService.selectProNameByCollegeName("人工智能学院");
        if (list == null) throw new AssertionError("没有专业开设或不存在此学院");
        else for (var x : list)
            System.out.println(x);
         */
    }

    @Test
    public void testProfessionalService(){
        //增设专业
        /*
        int test1 = professionalService.addProfessional("物联网", "人工智能学院");
        int test2 = professionalService.addProfessional("软件工程", "人工智能学院");
        int test3 = professionalService.addProfessional("影视制作", "艺术设计学院");
        */
    }

    @Test
    public void testGuideService(){
        //增加素导
        /*
        Guide guide = new Guide();
        guide.setGuideName("素导三号");
        guide.setGuideSex("女");
        int test = guideService.addGuide(guide, "人工智能学院");
        System.out.println(test);
         */

    }

    @Test
    public void testClazzService(){

        /*
        Clazz clazz = new Clazz();
        clazzService.addClazz(clazz, "软件工程1602", "开天辟地素导一号");
        clazzService.addClazz(clazz, "软件工程1601", "开天辟地素导一号");
         */
        /*
        for (var x : clazzService.selectAllClazz("0103"))
            System.out.println(x);
         */
    }

    @Test
    public void testStudentService(){
        for (int i = 1; i < 41; i++)
            studentService.addStudent("影视制作学生"+i+"号", "男", "02011901");
//        for (var x : studentService.selectAllStudent("01031901"))
//            System.out.println(x);
    }
}
