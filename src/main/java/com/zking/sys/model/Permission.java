package com.zking.sys.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private Long permissionId;

    private String permissionName;

    private Integer level;

    private Long parentPermissionId;

    private Integer available;

    private String permission;

    public Permission(Long permissionId, String permissionName, Integer level, Long parentPermissionId, Integer available, String permission) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.level = level;
        this.parentPermissionId = parentPermissionId;
        this.available = available;
        this.permission = permission;
    }

    public Permission() {
        super();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentPermissionId() {
        return parentPermissionId;
    }

    public void setParentPermissionId(Long parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}