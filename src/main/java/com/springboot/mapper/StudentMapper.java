package com.springboot.mapper;

import com.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
   @Select("select * from student")
   List<Student> findAll();
   @Insert("insert into student values(null,#{sname},#{age},#{cid})")
   int insert(Student student);
   @Update("update student set sname=#{sname},age=#{age},cid=#{cid} where sid=#{sid}")
   int update(Student student);
   @Delete("delete from student where sid=#{sid}")
   int delete(Integer sid);
   @Select("select * from student where sid=#{sid}")
   Student findOne(Integer sid);
}
