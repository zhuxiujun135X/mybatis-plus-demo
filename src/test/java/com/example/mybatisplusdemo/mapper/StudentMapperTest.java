package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplusdemo.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.insert;

/**
 * Mapper层测试
 */
@SpringBootTest
class StudentMapperTest {

    @Resource
    StudentMapper studentMapper;

    /**
     * 数据插入
     */
    @Test
    void insertTest(){
        Student student = new Student();
        student.setName("");
        student.setGender(1);
        int insert = studentMapper.insert(student);
        Assertions.assertEquals(1,insert);
    }

    /**
     * 根据id修改数据
     */
    @Test
    void updateByIdTest(){
        Student student = new Student();
        student.setId(100001);
        student.setName("嬴政");
        student.setGender(1);
        int i = studentMapper.updateById(student);
        Assertions.assertEquals(1,i);
    }

    /**
     * 根据条件修改数据
     */
    @Test
    void updateTest(){
        UpdateWrapper<Student> wrapper = new UpdateWrapper<>();
        // 设置查询条件为 name = "刘邦",将名字等于刘邦的人改成刘彻
        wrapper.eq("name","刘邦");
        Student student = new Student();
        student.setName("刘彻");
        int i = studentMapper.update(student,wrapper);
        Assertions.assertEquals(1,i);
    }

    /**
     * 根据id删除数据
     */
    @Test
    void deleteByIdTest(){
        int i = studentMapper.deleteById(1);
        Assertions.assertEquals(1,i);
    }

    /**
     * 根据条件删除数据
     */
    @Test
    void deleteTest(){
        UpdateWrapper<Student> wrapper = new UpdateWrapper<>();
        // 设置查询条件为 name = "刘邦",将名字等于刘邦的人删除
        wrapper.eq("name","刘邦");
        int i = studentMapper.delete(wrapper);
        Assertions.assertEquals(1,i);
    }

    /**
     * 根据id查询单条数据
     */
    @Test
    void selectByIdTest(){
        Student student = studentMapper.selectById(100001);
        Assertions.assertEquals("嬴政",student.getName());
    }

    /**
     * 根据条件查询单条数据
     */
    @Test
    void selectOneTest(){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        // 设置查询条件为 name = "刘备"
        wrapper.eq("name","刘备");
        Student student = studentMapper.selectOne(wrapper);
        Assertions.assertEquals(100004,student.getId());
    }

    /**
     * 根据id查询多条数据
     */
    @Test
    void selectBatchIdsTest(){
        List<Integer> ids = new ArrayList<>();
        ids.add(100001);
        ids.add(100004);
        ids.add(100005);
        List<Student> list = studentMapper.selectBatchIds(ids);
        list.forEach(student -> System.out.println(student.getName()));
        Assertions.assertEquals(3,list.size());
    }

    /**
     * 根据条件查询多条数据
     */
    @Test
    void selectListTest(){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        // 设置查询条件为 id>100001
        wrapper.gt("id",100001);
        List<Student> list = studentMapper.selectList(wrapper);
        list.forEach(student -> System.out.println(student.getName()));
        Assertions.assertEquals(4, list.size());
    }
}