package com.vb.beans;

import java.math.BigDecimal;

/**
 * UserT entity. @author MyEclipse Persistence Tools
 */

public class UserT implements java.io.Serializable {

	// Fields

	private String username;
	private String pwd;
	private String truename;
	private String sex;
	private BigDecimal age;
	private String major;
	private String sno;
	private String himage;
	private String authorityId;
	private BigDecimal score;
	private BigDecimal tasktime;
	private BigDecimal starrank;
	private BigDecimal levelrank;
	private BigDecimal scoreAvailable;

	// Constructors

	/** default constructor */
	public UserT() {
	}

	/** minimal constructor */
	public UserT(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	/** full constructor */
	public UserT(String username, String pwd, String truename, String sex,
			BigDecimal age, String major, String sno, String himage,
			String authorityId, BigDecimal score, BigDecimal tasktime,
			BigDecimal starrank, BigDecimal levelrank, BigDecimal scoreAvailable) {
		this.username = username;
		this.pwd = pwd;
		this.truename = truename;
		this.sex = sex;
		this.age = age;
		this.major = major;
		this.sno = sno;
		this.himage = himage;
		this.authorityId = authorityId;
		this.score = score;
		this.tasktime = tasktime;
		this.starrank = starrank;
		this.levelrank = levelrank;
		this.scoreAvailable = scoreAvailable;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public BigDecimal getAge() {
		return this.age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getHimage() {
		return this.himage;
	}

	public void setHimage(String himage) {
		this.himage = himage;
	}

	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getTasktime() {
		return this.tasktime;
	}

	public void setTasktime(BigDecimal tasktime) {
		this.tasktime = tasktime;
	}

	public BigDecimal getStarrank() {
		return this.starrank;
	}

	public void setStarrank(BigDecimal starrank) {
		this.starrank = starrank;
	}

	public BigDecimal getLevelrank() {
		return this.levelrank;
	}

	public void setLevelrank(BigDecimal levelrank) {
		this.levelrank = levelrank;
	}

	public BigDecimal getScoreAvailable() {
		return this.scoreAvailable;
	}

	public void setScoreAvailable(BigDecimal scoreAvailable) {
		this.scoreAvailable = scoreAvailable;
	}

}