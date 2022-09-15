package com.kainos.ea.db;

import com.kainos.ea.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetEmployeeByDept {

    public static List<Employee> execute(String dept) {

        List<Employee> myEmployees = new ArrayList<>();
        ResultSet rs = null;
        String query = "select * from Employees where department = '" + dept + "';";

        try (Connection myConnection = EmployeeDb.getConnection();
             PreparedStatement preparedQuery = myConnection.prepareStatement(query)) {

            rs = preparedQuery.executeQuery();

            while (rs.next()) {
//                Employee myEmployee = new Employee((short) rs.getInt("EmployeeNo"),
//                        rs.getString("EmployeeName"), rs.getString("Address"),
//                        rs.getString("NIN"),rs.getString("BankAccountNo"),
//                        rs.getInt("Salary"), rs.getString("Department"));
//                myEmployees.add(myEmployee);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return myEmployees;

    }
}
