package com.zking.test.biz;

import com.zking.sys.model.Role;
import com.zking.sys.service.IRoleBiz;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IRoleBizTest extends BaseTestCase {

    @Autowired
    private IRoleBiz roleBiz;

    private Role role;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        role = new Role();
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void del() throws Exception {
    }

    @Test
    public void doGrantRoleToUser() throws Exception {
//        role.setUserId(1L);
//        role.setRoleId(1L);
//        roleBiz.doGrantRoleToUser(role);

//        role.setUserId(2L);
//        role.setRoleId(2L);
//        roleBiz.doGrantRoleToUser(role);
    }

    @Test
    public void doRevokeRoleFromUser() throws Exception {
        role.setUserId(1L);
        role.setRoleId(1L);
        roleBiz.doRevokeRoleFromUser(role);
    }

    @Test
    public void doGrantPermissionToRole() throws Exception {
//        for(long i = 1; i <= 8;i++){
//            role.setRoleId(2L);
//            role.setPermissionId(i);
//            roleBiz.doGrantPermissionToRole(role);
//        }

//        long[] arr = new long[]{5L,7L};
//        for(int i = 0; i < arr.length;i++){
//            role.setRoleId(1L);
//            role.setPermissionId(arr[i]);
//            roleBiz.doGrantPermissionToRole(role);
//        }
    }

    @Test
    public void doRevokePermissionFromRole() throws Exception {
        role.setRoleId(2L);
        role.setPermissionId(1L);
        roleBiz.doRevokePermissionFromRole(role);
    }

}