package com.zx.office.dao;

import com.zx.office.entity.Clazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzDao {

    //增加班级, 需要根据专业id生成班级id, 专业(4)+年份(2)+编号(2)
    @Insert({"insert into clazz values (#{clazzId},#{clazzName},#{professionalId},#{guideId})"})
    int addClazz(Clazz clazz);

    //查询班级id
    @Select({"select clazz_id from clazz where professional_id = #{professionalId}"})
    List<String> selectCidByPid(String professionalId);

    //查询班级id最后两位
    @Select({"select right(clazz_id,2) from clazz where professional_id = #{professionalId}"})
    List<String> selectCidByPid2(String professionalId);

    //通过专业名字查询班级
    List<Clazz> selectClazzByProfessionalName(String professionalName);

    @Delete("delete from clazz where clazz_id = #{#clazzId}")
    int deleteByClazzId(String clazzId);
}
