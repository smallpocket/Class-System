package com.system.module;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
/**
 * @Author_ heper
 * @Time_ 2018/4/6 17:01
 * @Version_ 1.0
 * @Title_
 */
public class BaseModule
{
    /** 注入同名的一个ioc对象 */
    @Inject
    protected Dao dao;//injdect使得iocbean生效
}
