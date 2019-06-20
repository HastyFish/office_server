package com.zx.office.service;

import com.zx.office.dao.CollegeDao;
import com.zx.office.dao.ProfessionalDao;
import com.zx.office.entity.Clazz;
import com.zx.office.entity.Professional;
import com.zx.office.tools.ListProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessionalServiceImpl {
    @Autowired
    private ProfessionalDao professionalDao;

    @Autowired
    private CollegeDao collegeDao;

    /*
    在某某学院下新增某某专业
    存在bug
    专业id为 0101  0102  0103  0104的时候, 此时删除0101, 再次新增专业时, 新增id为0105而不是0101
    解决方法, 在查询专业id的时候只保留后两位, 之后是简单的补齐链表的算法
    由于大部分id后两位都是编号, 可以写成一个工具类
    已解决
    * */
    @Transactional
    public int addProfessional(String professionalName , String collegeName){
        Professional professional = new Professional();
        int collegeId = collegeDao.selectIdByName(collegeName);
        String collegeIdToString = collegeId >= 10 ? String.valueOf(collegeId) : "0"+collegeId;
        List<String> professionalIds = professionalDao.selectPidByCid(collegeId);
        int professionalIdLast2 = ListProcess.FirstMissVal(professionalIds);
        String professionalId;
        if (professionalIdLast2 == 0)
            professionalId = collegeIdToString + "01";
        else
            professionalId = professionalIdLast2 >= 10 ? collegeIdToString + professionalIdLast2 : collegeIdToString + "0" + professionalIdLast2;
        professional.setProfessionalId(professionalId);
        professional.setProfessionalName(professionalName);
        professional.setCollegeId(collegeId);
        return professionalDao.addProfessional(professional);
    }

}
