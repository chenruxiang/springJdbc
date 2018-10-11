package com.crx.impl;

import com.crx.bean.Department;
import com.crx.dao.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
@Component
public class DepartmentImplDAO implements DepartmentDAO {

    @Autowired
    private DataSource dataSource;
    /*public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Override
    public List<Department> queryDepartment() throws Exception {
        Connection conn = dataSource.getConnection();
        String sql = "Select d.dept_id, d.dept_no, d.dept_name from department d";
        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery(sql);
        List<Department> list = new ArrayList<Department>();
        while (rs.next()) {
            Long deptId = rs.getLong("dept_id");
            String deptNo = rs.getString("dept_no");
            String deptName = rs.getString("dept_name");
            Department dept = new Department(deptId, deptNo, deptName);
            list.add(dept);
        }
        return list;
    }
}
