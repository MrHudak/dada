package com.chinasofti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 用户表 user
 *
 * @author huda
 * @date 2019-08-01
 */
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**  */
	private Long id;
	/** 用户名 */
	private String username;
	/** 密码，加密存储 */
	@JsonIgnore
	private String password;
	/** 注册手机号 */
	private String phone;
	/** 注册邮箱 */
	private String email;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPhone()
	{
		return phone;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

}
