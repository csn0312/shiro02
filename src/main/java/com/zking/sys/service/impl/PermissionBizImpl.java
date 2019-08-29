package com.zking.sys.service.impl;

import com.zking.sys.service.IPermissionBiz;
import com.zking.sys.mapper.PermissionMapper;
import com.zking.sys.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionBizImpl implements IPermissionBiz {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int del(Permission permission) {
        return permissionMapper.deleteByPrimaryKey(permission.getPermissionId());
    }
}
