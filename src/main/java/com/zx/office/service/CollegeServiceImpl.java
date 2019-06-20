package com.zx.office.service;

import com.zx.office.dao.CollegeDao;
import com.zx.office.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollegeServiceImpl {

    @Autowired
    private CollegeDao collegeDao;

    @Transactional
    public int addCollege(String collegeName){
        return collegeDao.addCollege(collegeName);
    }


    public List<College> selectCollege(){
        return collegeDao.selectCollege();
    }
}
