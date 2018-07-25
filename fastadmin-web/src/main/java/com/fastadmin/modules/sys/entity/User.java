package com.fastadmin.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class User implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 登录账户
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 动态key
     */
    private String salt;

    /**
     * 用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)
     */
    private int type;

    /**
     * 状态(0:锁定,1启用)
     */
    private int status;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取登录账户
     *
     * @return username - 登录账户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录账户
     *
     * @param username 登录账户
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取动态key
     *
     * @return salt - 动态key
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置动态key
     *
     * @param salt 动态key
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)
     *
     * @return type - 用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)
     */
    public int getType() {
        return type;
    }

    /**
     * 设置用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)
     *
     * @param type 用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取状态(0:锁定,1启用)
     *
     * @return status - 状态(0:锁定,1启用)
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置状态(0:锁定,1启用)
     *
     * @param status 状态(0:锁定,1启用)
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}