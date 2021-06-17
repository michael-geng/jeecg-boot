package org.jeecg.modules.demo.student.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.student.entity.Student;
import org.jeecg.modules.demo.student.service.IStudentService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 订单
 * @Author:
 * @Date:   2020-12-03
 */
@Slf4j
@Api(tags="订单")
@RestController
@RequestMapping("/student/student")
public class StudentController {
	@Autowired
	private IStudentService studentService;

	//@AutoLog(value = "订单-分页列表查询")
	@ApiOperation(value="订单-分页列表查询", notes="订单-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Student>> queryPageList(Student student,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<Student>> result = new Result<IPage<Student>>();
		QueryWrapper<Student> queryWrapper = QueryGenerator.initQueryWrapper(student, req.getParameterMap());
		Page<Student> page = new Page<Student>(pageNo, pageSize);
		IPage<Student> pageList = studentService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}

	@AutoLog(value = "订单-添加")
	@ApiOperation(value="订单-添加", notes="订单-添加")
	@PostMapping(value = "/add")
	public Result<Student> add(@RequestBody Student student) {
		Result<Student> result = new Result<Student>();
		try {
			studentService.save(student);
			result.success("添加成功！");
		} catch (Exception e) {
			log.error("添加失败:{}", e);
			result.error500("操作失败：" + e.getMessage());
		}
		return result;
	}

	//@AutoLog(value = "订单-编辑")
	@ApiOperation(value="订单-编辑", notes="订单-编辑")
	@PutMapping(value = "/edit")
	public Result<Student> edit(@RequestBody Student student) {
		Result<Student> result = new Result<Student>();
		Student studentEntity = studentService.getById(student.getId());
		if(studentEntity == null) {
			result.error500("未找到数据!");
		}else {
			boolean ok = studentService.updateById(student);
			//TODO 返回false说明什么？
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}

	@AutoLog(value = "订单-通过id删除")
	@ApiOperation(value="订单-通过id删除", notes="订单-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		try {
			studentService.removeById(id);
		} catch (Exception e) {
			log.error("删除失败:{}", e.getMessage());
			return Result.error("删除失败：" + e.getMessage());
		}
		return Result.ok("删除成功!");
	}

	@AutoLog(value = "订单-批量删除")
	@ApiOperation(value="订单-批量删除", notes="订单-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<Student> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<Student> result = new Result<Student>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数错误！");
		}else {
			this.studentService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}

	//@AutoLog(value = "订单-通过id查询")
	@ApiOperation(value="订单-通过id查询", notes="订单-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Student> queryById(@RequestParam(name="id",required=true) String id) {
		Result<Student> result = new Result<Student>();
		Student student = studentService.getById(id);
		if(student==null) {
			result.error500("未找到数据!");
		}else {
			result.setResult(student);
			result.setSuccess(true);
		}
		return result;
	}

  /**
   * 导出excel
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
      // Step.1 组装查询条件
      QueryWrapper<Student> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              Student student = JSON.parseObject(deString, Student.class);
              queryWrapper = QueryGenerator.initQueryWrapper(student, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<Student> pageList = studentService.list(queryWrapper);
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "订单列表");
      mv.addObject(NormalExcelConstants.CLASS, Student.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("订单列表数据", "导出人:Jeecg", "导出信息"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
  }

  /**
   * 通过excel导入数据
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<Student> listStudents = ExcelImportUtil.importExcel(file.getInputStream(), Student.class, params);
              studentService.saveBatch(listStudents);
              return Result.ok("文件导入成功！数据行数:" + listStudents.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.ok("文件导入失败！");
  }

}
