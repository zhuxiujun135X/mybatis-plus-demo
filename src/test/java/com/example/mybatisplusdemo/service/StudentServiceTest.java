package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Service接口测试
 *
 * @author zhuxj
 */
@SpringBootTest
class StudentServiceTest {

    @Resource
    private StudentService studentService;

    /**
     * 批量插入数据
     */
    @Test
    void batchInsertTest() {
        List<Student> list = new ArrayList<>();
        String[] strings = {"刘备","关羽","张飞"};
        for (String string : strings) {
            Student student = new Student();
            student.setName(string);
            list.add(student);
        }
        boolean b = studentService.saveBatch(list);
        Assertions.assertTrue(b);
    }

    /**
     * 插入或修改数据
     * 根据实体对象的主键 id 进行判断，存在则更新记录，否则插入记录。
     */
    @Test
    void saveOrUpdateTest() {
        Student student = new Student();
        student.setId(1);
        student.setName("曹操");
        boolean b = studentService.saveOrUpdate(student);
        Assertions.assertTrue(b);
        Student res = studentService.getById(1);
        Assertions.assertEquals("曹操",res.getName());

        Student newstudent = new Student();
        newstudent.setId(1);
        newstudent.setName("赵云");
        b = studentService.saveOrUpdate(newstudent);
        Assertions.assertTrue(b);
        res = studentService.getById(1);
        Assertions.assertEquals("赵云",res.getName());
    }

    /**
     * 根据Map查询
     */
    @Test
    void selectByMapTest() {
        Map<String,Object> map = new HashMap<>();
        map.put("gender","1");
        //查询条件 gender="1"
        List<Student> list = studentService.listByMap(map);
        Assertions.assertEquals(6,list.size());
    }

    /**
     * 无条件分页查询
     */
    @Test
    void pageTest() {
        // 无条件分页查询，每页显示10条记录，查询第1页
        IPage<Student> page = new Page<>(1, 2);
        IPage<Student> studentPage = studentService.page(page);
        List<Student> studentList = studentPage.getRecords();
        studentList.forEach(student -> System.out.println(student.toString()));
        Assertions.assertEquals(6,studentList.size());
    }
}