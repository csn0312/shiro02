package com.zking.test.biz;

import com.zking.sys.model.Permission;
import com.zking.sys.service.IPermissionBiz;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IPermissionBizTest extends BaseTestCase {

    @Autowired
    private IPermissionBiz permissionBiz;

    private Permission permission;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        permission = new Permission();
    }

    @Test
    public void add() throws Exception {
        permission.setPermissionName("数据字典新增");
        permission.setLevel(2);
        permission.setParentPermissionId(1L);
        permission.setAvailable(1);
        permission.setPermission("system:dict:add");

        permissionBiz.add(permission);
    }

    @Test
    public void del() throws Exception {
        permission.setPermissionId(1L);
        permissionBiz.del(permission);
    }

}