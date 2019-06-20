package com.zx.office.dao;

import com.zx.office.entity.College;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollegeDao {
    //增加学院
    @Insert({"insert into college (college_name) values (#{collegeName})"})
    int addCollege(String collegeName);

    //根据学院名字查id
    @Select({"select college_id from college where college_name = #{collegeName}"})
    int selectIdByName(String collegeName);


    List<College> selectCollege();
}
