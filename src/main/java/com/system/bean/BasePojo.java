package com.system.bean;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

/**
 * @Author_ heper
 * @Time_ 2018/4/6 16:56
 * @Version_ 1.0
 * @Title_
 */
public class BasePojo
{
    @Column("ct")
    protected Date createTime;
    @Column("ut")
    protected Date updateTime;

    @Override
    public String toString()
    {
        // 这不是必须的, 只是为了debug的时候方便看
        return Json.toJson(this, JsonFormat.compact());
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}
