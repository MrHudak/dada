package com.chinasofti.domain;


import java.io.Serializable;

/**
 * 菜单分类表 category
 *
 * @author huda
 * @date 2019-08-01
 */
public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 类目ID */
	private Long id;
	/** 商品分类名称 */
	private String name;
	/** 所属父类目，当ID=0时，代表的是一级的类目 */
	private Long parentId;
	/** 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数 */
	private Integer sortOrder;
	/**  */
	private Integer showInNav;
	/** 状态。可选值:1(正常),2(删除) */
	private Integer isShow;
	/**  */
	private Integer grade;
	/**  */
	private String filterAttr;
	/**  */
	private Integer isTopStyle;
	/**  */
	private String topStyleTpl;
	/**  */
	private String styleIcon;
	/**  */
	private String catIcon;
	/**  */
	private Integer isTopShow;
	/**  */
	private String categoryLinks;
	/**  */
	private String categoryTopic;
	/**  */
	private String catAliasName;
	/**  */
	private Integer commissionRate;
	/**  */
	private String touchIcon;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	public void setParentId(Long parentId)
	{
		this.parentId = parentId;
	}

	public Long getParentId()
	{
		return parentId;
	}
	public void setSortOrder(Integer sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder()
	{
		return sortOrder;
	}
	public void setShowInNav(Integer showInNav)
	{
		this.showInNav = showInNav;
	}

	public Integer getShowInNav()
	{
		return showInNav;
	}
	public void setIsShow(Integer isShow)
	{
		this.isShow = isShow;
	}

	public Integer getIsShow()
	{
		return isShow;
	}
	public void setGrade(Integer grade)
	{
		this.grade = grade;
	}

	public Integer getGrade()
	{
		return grade;
	}
	public void setFilterAttr(String filterAttr)
	{
		this.filterAttr = filterAttr;
	}

	public String getFilterAttr()
	{
		return filterAttr;
	}
	public void setIsTopStyle(Integer isTopStyle)
	{
		this.isTopStyle = isTopStyle;
	}

	public Integer getIsTopStyle()
	{
		return isTopStyle;
	}
	public void setTopStyleTpl(String topStyleTpl)
	{
		this.topStyleTpl = topStyleTpl;
	}

	public String getTopStyleTpl()
	{
		return topStyleTpl;
	}
	public void setStyleIcon(String styleIcon)
	{
		this.styleIcon = styleIcon;
	}

	public String getStyleIcon()
	{
		return styleIcon;
	}
	public void setCatIcon(String catIcon)
	{
		this.catIcon = catIcon;
	}

	public String getCatIcon()
	{
		return catIcon;
	}
	public void setIsTopShow(Integer isTopShow)
	{
		this.isTopShow = isTopShow;
	}

	public Integer getIsTopShow()
	{
		return isTopShow;
	}
	public void setCategoryLinks(String categoryLinks)
	{
		this.categoryLinks = categoryLinks;
	}

	public String getCategoryLinks()
	{
		return categoryLinks;
	}
	public void setCategoryTopic(String categoryTopic)
	{
		this.categoryTopic = categoryTopic;
	}

	public String getCategoryTopic()
	{
		return categoryTopic;
	}
	public void setCatAliasName(String catAliasName)
	{
		this.catAliasName = catAliasName;
	}

	public String getCatAliasName()
	{
		return catAliasName;
	}
	public void setCommissionRate(Integer commissionRate)
	{
		this.commissionRate = commissionRate;
	}

	public Integer getCommissionRate()
	{
		return commissionRate;
	}
	public void setTouchIcon(String touchIcon)
	{
		this.touchIcon = touchIcon;
	}

	public String getTouchIcon()
	{
		return touchIcon;
	}


}
