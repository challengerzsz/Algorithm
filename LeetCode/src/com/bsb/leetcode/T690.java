package com.bsb.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-24 16:50
 */
public class T690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    // 员工的重要性
    // O(n^2)
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                // 没有子员工
                if (employee.subordinates.size() == 0) {
                    return employee.importance;
                }
                for (int temp : employee.subordinates) {
                    employee.importance += getImportance(employees, temp);
                }
                return employee.importance;
            }
        }
        return 0;
    }

    // Map优化每一趟的线性查找
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee temp : employees) {
            map.put(temp.id, temp);
        }
        return helper(map, id);
    }

    private int helper(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        for (int temp : employee.subordinates) {
            employee.importance += helper(map, temp);
        }
        return employee.importance;
    }
}
