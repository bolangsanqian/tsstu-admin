package com.fastadmin.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Table(name = "sys_resource")
public class Resource implements Serializable {
    /**
     * 资源ID
     */
    @Id
    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 资源类型（0：菜单，1：页面，2：功能)
     */
    private Byte type;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源代码
     */
    private String code;

    /**
     * 权限标识
     */
    @Column(name = "permission_tag")
    private String permissionTag;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态(0：停用，1：启用)
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 标签标示
     */
    @Column(name = "label_tag")
    private String labelTag;

    private static final long serialVersionUID = 1L;
}