package com.zking.test.biz;

import com.zking.sys.model.User;
import com.zking.sys.service.IUserBiz;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class IStaffTest extends BaseTestCase {

    @Autowired
    private IUserBiz userBiz;

    private User user;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    @Test
    public void loadByUsername() throws Exception {
        user.setUsername("zs");
        User u = userBiz.loadByUsername(this.user);
        System.out.println(u);

    }

    @Test
    public void doLogin() throws Exception {
        user.setUsername("zs");
       // user.setPassword("888888");
        user.setPassword("123456");
        String message = userBiz.doLogin(user);
        System.out.println(message);
    }

    @Test
    public void doRegister() throws Exception {
        user.setUsername("zs");
        //user.setUsername("ls");
        user.setPassword("888888");
        int rowCount = userBiz.doRegister(user);
        System.out.println(rowCount);
        System.out.println(user.getUserId());
    }

    @Test
    public void listPermissionsByUserName() throws Exception {
        user.setUsername("ls");

        Set<String> permissions = userBiz.listPermissionsByUserName(user);
        System.out.println(permissions);
    }


    @Test
    public void updatePassword() throws Exception {
        user.setUsername("admin");
        user.setPassword("123456");

        int rowCount = userBiz.updatePassword(user);
        System.out.println(rowCount);
    }

    @Test
    public void doResetPassword() throws Exception {
        user.setUsername("admin");
        user.setPassword("888888");

        int rowCount = userBiz.doResetPassword(user);
        System.out.println(rowCount);
    }
}