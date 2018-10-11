package com.crx.dao;

import com.crx.bean.Department;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public interface DepartmentDAO {
    public List<Department> queryDepartment() throws Exception;
}
