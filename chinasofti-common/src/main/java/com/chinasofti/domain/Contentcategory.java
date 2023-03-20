package com.chinasofti.domain;


import java.io.Serializable;

/**
 * 内容分类表 contentcategory
 *
 * @author huda
 * @date 2019-08-01
 */
public class Contentcategory implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 类目ID */
	private Long id;
	/** 父类目ID=0时，代表的是一级的类目 */
	private Long parentid;
	/** 分类名称 */
	private String name;
	/** 状态。可选值:1(正常),2(删除) */
	private Integer status;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setParentid(Long parentid)
	{
		this.parentid = parentid;
	}

	public Long getParentid()
	{
		return parentid;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getStatus()
	{
		return status;
	}

}
