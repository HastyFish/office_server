# office_server
>武昌理工竞赛作品后端部分  
>软件工程1604某小组成员分布:  1个技术总监+3个杂物人员  
><a href="https://github.com/HastyFish/office_client">前端部分</a>  
>springboot+mybatis

## 项目技术简介  
采用Rest架构，即前台发出请求，后台只需要传入数据即可  
后台结构，控制层根据请求调用相应服务层，服务层选择对应持久层，持久层用对应的实体层表示查询出来的数据  
持久层采用注解+xml配置文件混编，长的查询数据用xml，例如
```
<resultMap id="selectAllCollege" type="com.zx.office.entity.College">
        <id property="collegeId" column="college_id"/>
        <result property="collegeName" column="college_name"/>
        <collection property="professionalList" ofType="com.zx.office.entity.Professional">
            <id property="professionalId" column="professional_id"/>
            <result property="professionalName" column="professional_name"/>
        </collection>
    </resultMap>
    <select id="selectCollege" resultMap="selectAllCollege">
            select c.college_id, c.college_name, p.professional_id, p.professional_name
            from college c left join professional p on c.college_id = p.college_id
    </select>
```
主要问题跨域，解决方案:在控制层的类上或方法上添加`@CrossOrigin(origins = "http://localhost:8080")`  

## 数据库设计
自信达到第三范式，因为可能出现数据冗余的点我都省去了，部分设计请看er图，具体部分请看test.sql

## 未来扩展点
事物管理`@Transactional`
