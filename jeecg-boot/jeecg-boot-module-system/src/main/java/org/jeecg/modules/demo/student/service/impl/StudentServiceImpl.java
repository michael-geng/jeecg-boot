package org.jeecg.modules.demo.student.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.jeecg.modules.demo.student.entity.Student;
import org.jeecg.modules.demo.student.mapper.StudentMapper;
import org.jeecg.modules.demo.student.service.IStudentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 订单
 * @Author: jeecg-boot
 * @Date:   2019-07-09
 * @Version: V1.0
 */
@Service
@DS("multi-datasource1")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
