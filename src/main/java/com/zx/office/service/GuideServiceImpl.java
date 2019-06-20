package com.zx.office.service;

import com.zx.office.dao.CollegeDao;
import com.zx.office.dao.GuideDao;
import com.zx.office.entity.Guide;
import com.zx.office.tools.ListProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuideServiceImpl {
    @Autowired
    private GuideDao guideDao;

    @Autowired
    private CollegeDao collegeDao;

    /*
    新增素导, 此处添加id到guide类中, 其他参数由控制类获得前台数据添加到guide中
    * */
    @Transactional
    public int addGuide(Guide guide, String collegeName){
        int collegeId = collegeDao.selectIdByName(collegeName);
        String collegeIdToString = collegeId < 10 ? "0"+collegeId : String.valueOf(collegeId);
        List<String> guideIds = guideDao.selectGid(collegeIdToString);
        int guideId = ListProcess.FirstMissVal(guideIds);
        String guideIdToString;
        if (guideId == 0)
            guideIdToString = "G" + collegeIdToString + "01";
        else
            guideIdToString = "G" + collegeIdToString + (guideId >= 10 ? guideId : "0" + guideId);
        guide.setGuideId(guideIdToString);
        return guideDao.addGuide(guide);
    }
}
