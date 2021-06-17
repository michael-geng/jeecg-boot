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
 * @Author: system
 * @Date:   2020-12-03
 * @Version: V1.0
 */
@Data
@TableName("STUDENT")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="STUDENT对象", description="订单")
public class Student {
    
	/**主键id*/
	@TableId(type = IdType.UUID)
    @ApiModelProperty(value = "主键id")
	private java.lang.Integer id;
	/**用户编码*/
	@Excel(name = "用户编码", width = 15)
    @ApiModelProperty(value = "用户编码")
	private java.lang.String userno;
	/**用户登录账号*/
	@Excel(name = "用户登录账号", width = 15)
    @ApiModelProperty(value = "用户登录账号")
	private java.lang.String username;
	/**真实姓名*/
	@Excel(name = "真实姓名", width = 15)
    @ApiModelProperty(value = "真实姓名")
	private java.lang.String realname;
	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
	private java.lang.String idCard;
	/**用户昵称*/
	@Excel(name = "用户昵称", width = 15)
    @ApiModelProperty(value = "用户昵称")
	private java.lang.String nickname;
	/**密码*/
	@Excel(name = "密码", width = 15)
    @ApiModelProperty(value = "密码")
	private java.lang.String password;
	/**md5密码盐*/
	@Excel(name = "md5密码盐", width = 15)
    @ApiModelProperty(value = "md5密码盐")
	private java.lang.String salt;
	/**头像*/
	@Excel(name = "头像", width = 15)
    @ApiModelProperty(value = "头像")
	private java.lang.String avatar;
	/**头像审核状态：0 默认、1 审核中 2 审核通过 -1 审核失败*/
	@Excel(name = "头像审核状态：0 默认、1 审核中 2 审核通过 -1 审核失败", width = 15)
    @ApiModelProperty(value = "头像审核状态：0 默认、1 审核中 2 审核通过 -1 审核失败")
	private java.lang.Integer avatarStatus;
	/**生日*/
	@Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
	private java.util.Date birthday;
	/**性别（1：男 2：女）*/
	@Excel(name = "性别（1：男 2：女）", width = 15)
    @ApiModelProperty(value = "性别（1：男 2：女）")
	private java.lang.Integer sex;
	/**电子邮件*/
	@Excel(name = "电子邮件", width = 15)
    @ApiModelProperty(value = "电子邮件")
	private java.lang.String email;
	/**省份*/
	@Excel(name = "省份", width = 15)
    @ApiModelProperty(value = "省份")
	private java.lang.String province;
	/**城市*/
	@Excel(name = "城市", width = 15)
    @ApiModelProperty(value = "城市")
	private java.lang.String city;
	/**状态(1：正常  2：冻结 3、注销）*/
	@Excel(name = "状态(1：正常  2：冻结 3、注销）", width = 15)
    @ApiModelProperty(value = "状态(1：正常  2：冻结 3、注销）")
	private java.lang.Integer status;
	/**删除状态（0，正常，1已删除）*/
	@Excel(name = "删除状态（0，正常，1已删除）", width = 15)
    @ApiModelProperty(value = "删除状态（0，正常，1已删除）")
	private java.lang.Integer delFlag;
	/**简介*/
	@Excel(name = "简介", width = 15)
    @ApiModelProperty(value = "简介")
	private java.lang.String intro;
	/**注册来源 1：主动注册 2：后台导入*/
	@Excel(name = "注册来源 1：主动注册 2：后台导入", width = 15)
    @ApiModelProperty(value = "注册来源 1：主动注册 2：后台导入")
	private java.lang.Integer source;
	/**创建时间*/
	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
	private java.util.Date createTime;
	/**更新时间*/
	@Excel(name = "更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
	private java.util.Date updateTime;
	/**userType*/
	@Excel(name = "userType", width = 15)
    @ApiModelProperty(value = "userType")
	private java.lang.Integer userType;
}
