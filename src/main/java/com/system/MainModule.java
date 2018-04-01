package com.system;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * @Author_ heper
 * @Time_ 2018/4/1 19:51
 * @Version_ 1.0
 * @Title_
 */
// 请注意星号!!不要拷贝少了
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
        // 这个package下所有带@IocBean注解的类,都会登记上
        "*anno", "com.system",
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
@Modules(scanPackage=true)
@SetupBy(value=MainSetup.class)
public class MainModule
{
    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String doHello() {
        return "Hello Nutz";
    }
}
