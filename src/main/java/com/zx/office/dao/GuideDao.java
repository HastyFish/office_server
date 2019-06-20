package com.zx.office.dao;

import com.zx.office.entity.Guide;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GuideDao {
    //增加素导 素导编号 由G开头 身份(1)+学院(2)+编号(2)
    @Insert({"insert into guide (guide_id, guide_name, guide_sex)" +
            "values (#{guideId}, #{guideName}, #{guideSex})"})
    int addGuide(Guide guide);

    //查询素导id 用学院id做模糊查询, 只取最后两位
    @Select({"select right(guide_id,2) from guide where guide_id like concat('G',#{collegeId},'%') "})
    List<String> selectGid(String collegeId);

    //查询id 通过名字
    @Select({"select guide_id from guide where guide_name = #{guideName}"})
    String selectGidByName(String guideName);
}
