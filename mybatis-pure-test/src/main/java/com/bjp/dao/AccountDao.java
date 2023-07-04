package com.bjp.dao;

import com.bjp.domain.Account;

/**
 * @author XuHan
 * @date 2023/4/9 16:39
 */
public interface AccountDao {
    /**
     * 主键查询
     * @param id
     * @return
     */
    public Account selectById(Integer id);

    /**
     * 这是个默认方法 jdk1.8 开始有
     * @return 默认方法需要有实现
     */
    default Account getDefaultMethod(){
        return new Account();
    }

    /**
     * 这个就是object的默认方法
     * @return
     */
    @Override
    public String toString();
}
