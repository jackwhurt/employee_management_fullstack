package com.kainos.ea.db;

import com.kainos.ea.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetEmployeeByDept {

    public static List<Employee> execute(String dept) {

        List<Employee> myEmployees = new ArrayList<>();
        ResultSet rs = null;
        String query = "select * from Employees where department = ?;";

        Connection myConnection = EmployeeDb.getConnection();

        try (PreparedStatement preparedQuery = myConnection.prepareStatement(query)) {

            preparedQuery.setString(1,dept);
            rs = preparedQuery.executeQuery();

            while (rs.next()) {
                Employee myEmployee = new Employee(rs.getInt("EmployeeID"),
                        rs.getString("Address"), rs.getString("Name"),
                        rs.getString("Postcode"),rs.getFloat("StartingSalary"),
                        rs.getString("BankNum"), rs.getString("NIN"),
                        rs.getString("Department"));
                myEmployees.add(myEmployee);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return myEmployees;

    }
}
