package com.zx.office.dao;

import com.zx.office.entity.Professional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProfessionalDao {
    //增加专业, 需要根据学院id生成专业id  学院(2)+编号(2)
    @Insert({"insert into professional (professional_id, professional_name, college_id)" +
            "values (#{professionalId}, #{professionalName}, #{collegeId})"})
    int addProfessional(Professional professional);

    //查询id号,根据学院id
    @Select({"select right(professional_id,2) from professional where college_id = #{collegeId}"})
    List<String> selectPidByCid(int collegeId);

    //根据专业名字查专业id
    @Select({"select professional_id from professional where professional_name = #{professionalName}"})
    String selectPidByPname(String professionalName);

    //根据专业Id查专业名字
    @Select({"select professional_name from professional where professional_id = #{professionalId}"})
    String selectPnameByPid(String professionalId);
}
