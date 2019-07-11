package org.jeecg.modules.demo.student.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 订单
 * @Author: jeecg-boot
 * @Date:   2019-07-09
 * @Version: V1.0
 */
@Data
@TableName("student")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="student对象", description="订单")
public class Student {
    
	/**id*/
	@TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
	private String id;
	/**name*/
	@Excel(name = "name", width = 15)
    @ApiModelProperty(value = "name")
	private String name;
	/**classId*/
	@Excel(name = "classId", width = 15)
    @ApiModelProperty(value = "classId")
	private Integer classId;
}
