package com.kainos.ea.db;

import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetFinanceReport {

    public static Map<String, Integer> execute() {

        Map<String, Integer> myFinanceRepMap = new HashMap<>();

        ResultSet rs = null;
        String query = "SELECT EmployeeID, Name, (StartingSalary * 0.75) AS GrossPay From Employees" +
                " WHERE Department != 'Sales' UNION SELECT Employees.EmployeeID, Name, (Commission * TotalSales / 100)" +
                " AS GrossPay FROM Employees, SalesEmployees WHERE Department = 'Sales' AND Employees.EmployeeID = " +
                "SalesEmployees.EmployeeID;";

        Connection myConnection = EmployeeDb.getConnection();

        try (Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException("Database connection null");

            rs = st.executeQuery(query);


            while (rs.next()) {

                myFinanceRepMap.put(rs.getString("Name"), rs.getInt("GrossPay"));

            }


        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return myFinanceRepMap;

    }

}
