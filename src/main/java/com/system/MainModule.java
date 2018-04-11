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
@IocBy(type=ComboIocProvider.class, args=
        {"*js", "ioc/",
        // 这个package下所有带@IocBean注解的类,都会登记上
        "*anno", "com.system",
        "*tx", // 事务拦截 aop
        //"*async"}) // 异步执行aop
         "*quartz"})
//自动扫描
@Modules(scanPackage=true)
//数据库
@SetupBy(value=MainSetup.class)
//成功视图
@Ok("json:full")
//失败页面
@Fail("jsp:jsp.500")
//国际化资源包
@Localization(value="msg/", defaultLocalizationKey="zh-CN")
//动作链配置
@ChainBy(args="mvc/nutzbook-mvc-chain.js")
public class MainModule
{
    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String doHello() {
        return "Hello Nutz";
    }
}
