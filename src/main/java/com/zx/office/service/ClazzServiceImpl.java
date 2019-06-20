package com.zx.office.service;

import com.zx.office.dao.ClazzDao;
import com.zx.office.dao.GuideDao;
import com.zx.office.dao.ProfessionalDao;
import com.zx.office.dao.StudentDao;
import com.zx.office.entity.Clazz;
import com.zx.office.entity.Student;
import com.zx.office.tools.ListProcess;
import com.zx.office.tools.TimeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClazzServiceImpl {
    @Autowired
    private GuideDao guideDao;

    @Autowired
    private ProfessionalDao professionalDao;

    @Autowired
    private ClazzDao clazzDao;

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public int addClazz(Clazz clazz, String clazzName, String guideName){
        String professionalId = professionalDao.selectPidByPname(clazzName.substring(0,clazzName.length()-4));
        String year = TimeProcess.getPreYear();
        List<String> clazzIds = clazzDao.selectCidByPid2(professionalId);
        String clazzId;
        if (clazzIds.size() == 0)
            clazzId = professionalId + year + "01";
        else {
            int tmp = ListProcess.FirstMissVal(clazzIds);
            clazzId = professionalId + year + (tmp >= 10 ? tmp : "0"+tmp);
        }
        clazz.setClazzId(clazzId);
        clazz.setClazzName(clazzName);
        clazz.setProfessionalId(professionalId);
        clazz.setGuideId(guideDao.selectGidByName(guideName));
        return clazzDao.addClazz(clazz);
    }

    public List<Clazz> selectAllClazz(String professionalId){
        String professionalName = professionalDao.selectPnameByPid(professionalId);
        return clazzDao.selectClazzByProfessionalName(professionalName);
    }

    public int deleteByClazzId(String clazzId) {
        List<Student> students = studentDao.selectAllStudent(clazzId);
        if (students.size() == 0)
            return clazzDao.deleteByClazzId(clazzId);
        else return 0;
    }
}
