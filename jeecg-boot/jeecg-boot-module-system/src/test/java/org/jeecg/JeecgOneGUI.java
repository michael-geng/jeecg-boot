package org.jeecg;

import org.jeecgframework.codegenerate.generate.impl.CodeGenerateOne;
import org.jeecgframework.codegenerate.generate.pojo.TableVo;
import org.jeecgframework.codegenerate.window.CodeWindow;

/**
 * @Title: 单表代码生成器入口
 * @Author 张代浩
 * @site www.jeecg.org
 * @Version:V1.0.1
 */
public class JeecgOneGUI {

	/** 详细使用手册： http://jeecg-boot.mydoc.io/?t=338140 */
    public static void main(String[] args) {
    	//new CodeWindow().pack();
		TableVo tableVo = new TableVo();
		tableVo.setTableName("student");//表名
		tableVo.setEntityName("Student");	 //实体名
		tableVo.setEntityPackage("student");	 //包名
		tableVo.setFtlDescription("订单");	 //描述

		try {
			new CodeGenerateOne(tableVo).generateCodeFile();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}