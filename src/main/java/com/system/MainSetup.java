package com.system;

import com.system.bean.User;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import java.util.Date;

/**
 * @Author_ heper
 * @Time_ 2018/4/1 20:15
 * @Version_ 1.0
 * @Title_
 */
public class MainSetup implements Setup
{
    // 特别留意一下,是init方法,不是destroy方法!!!!!
    public void init(NutConfig nc) {
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        // 如果没有createTablesInPackage,请检查nutz版本
        Daos.createTablesInPackage(dao, "com.system", false);
        // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            User user = new User();
            user.setName("admin");
            user.setPassword("123456");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            dao.insert(user);
        }
    }

    public void destroy(NutConfig nc) {
    }

}
