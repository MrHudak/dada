package com.chinasofti.domain;


import java.io.Serializable;

/**
 * 内容表 content
 *
 * @author huda
 * @date 2019-08-01
 */
public class Content implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**  */
	private Long id;
	/** 内容类目ID */
	private Long categoryid;
	/** 内容标题 */
	private String title;
	/** 子标题 */
	private String subtitle;
	/** 标题描述 */
	private String titledesc;
	/** 链接 */
	private String url;
	/** 图片绝对路径 */
	private String pic;
	/** 图片2 */
	private String pic2;
	/** 内容 */
	private String content;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setCategoryid(Long categoryid)
	{
		this.categoryid = categoryid;
	}

	public Long getCategoryid()
	{
		return categoryid;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
	public void setSubtitle(String subtitle)
	{
		this.subtitle = subtitle;
	}

	public String getSubtitle()
	{
		return subtitle;
	}
	public void setTitledesc(String titledesc)
	{
		this.titledesc = titledesc;
	}

	public String getTitledesc()
	{
		return titledesc;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUrl()
	{
		return url;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}

	public String getPic()
	{
		return pic;
	}
	public void setPic2(String pic2)
	{
		this.pic2 = pic2;
	}

	public String getPic2()
	{
		return pic2;
	}
	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}

}
