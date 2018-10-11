package com.crx;

import com.crx.bean.Department;
import com.crx.dao.DepartmentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public class MainDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDAO departmentDAO = (DepartmentDAO)context.getBean("departmentImplDAO");
        List<Department> depts = departmentDAO.queryDepartment();
        for (Department dept : depts) {
            System.out.println("Dept ID " + dept.getDeptId());
            System.out.println("Dept No " + dept.getDeptNo());
            System.out.println("Dept Name " + dept.getDeptName());
        }
    }
}
