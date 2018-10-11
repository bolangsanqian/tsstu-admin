package com.fastadmin.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
@Data
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
}