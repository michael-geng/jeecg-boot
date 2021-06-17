package org.jeecg.modules.demo.student.service.impl;

import org.jeecg.modules.demo.student.entity.Student;
import org.jeecg.modules.demo.student.mapper.StudentMapper;
import org.jeecg.modules.demo.student.service.IStudentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 订单
 * @Author: system
 * @Date:   2020-12-03
 * @Version: V1.0
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
