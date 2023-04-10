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
}
