package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusdemo.service.StudentService;
import com.example.mybatisplusdemo.domain.Student;
import com.example.mybatisplusdemo.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author zhuxj
* @description 针对表【student(测试)】的数据库操作Service实现
* @createDate 2025-01-23 09:19:54
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

}




