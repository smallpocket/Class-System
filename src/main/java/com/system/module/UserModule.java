package com.system.module;

import com.system.bean.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpSession;

/**
 * @Author_ heper
 * @Time_ 2018/4/1 20:22
 * @Version_ 1.0
 * @Title_
 */
@IocBean // 还记得@IocBy吗? 这个跟@IocBy有很大的关系哦
@At("/user")
@Ok("json")
@Fail("http:500")
public class UserModule
{
    @Inject
    protected Dao dao; // 就这么注入了,有@IocBean它才会生效
    @At
    public int count() {
        return dao.count(User.class);
    }
    @At
    public Object login(@Param("username")String name, @Param("password")String password, HttpSession session) {
        User user = dao.fetch(User.class, Cnd.where("name", "=", name).and("password", "=", password));
        if (user == null) {
            return false;
        } else {
            session.setAttribute("me", user.getId());
            return true;
        }
    }
    @At
    @Ok(">>:/")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}

