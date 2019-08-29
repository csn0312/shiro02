package com.zking.sys.service;

import com.zking.sys.model.Permission;

public interface IPermissionBiz {
    int add(Permission permission);
    int del(Permission permission);
}
