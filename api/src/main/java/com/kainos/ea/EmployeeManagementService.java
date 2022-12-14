package com.kainos.ea;

import com.kainos.ea.db.GetEmployeeByDept;
import com.kainos.ea.db.GetFinanceReport;
import com.kainos.ea.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.List;
import java.util.Map;

import com.kainos.ea.db.EmployeeDb;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class EmployeeManagementService {

    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @GET
    @Path("/employees/{dept}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesByDept(@PathParam("dept") String dept) {

        List<Employee> myEmployees = GetEmployeeByDept.execute(dept);
        return myEmployees;
    }

    @GET
    @Path("/employees/finance-report")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getFinanceReport() {

        Map<String, Integer> myFinanceRepMap = GetFinanceReport.execute();
        return myFinanceRepMap;

    }

    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMsg(Employee message) {
        try {

            Connection c = EmployeeDb.getConnection();
            Statement st = c.createStatement();
            PreparedStatement statement = c.prepareStatement("INSERT INTO `Employees` (Name, Address, Postcode, StartingSalary, BankNum, NIN, Department) VALUES (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, message.getName());
            statement.setString(2, message.getAddress());
            statement.setString(3, message.getPostcode());
            statement.setFloat(4, message.getStartingSalary());
            statement.setString(5, message.getBankNum());
            statement.setString(6,message.getNIN());
            statement.setString(7, message.getDepartment());

            statement.execute();
            return Response.ok("User added successfully!").build();
        } catch (SQLException e) {
            System.err.println("Exception while creating employee: " + e);
            return Response.status(400, "Invalid employee data").build();
        }
    }

    @POST
    @Path("/salesEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMsg(SalesEmployee message) {
        try {

            Connection c = EmployeeDb.getConnection();
            Statement st = c.createStatement();
            PreparedStatement statement = c.prepareStatement("INSERT INTO SalesEmployees (EmployeeID, Commission, TotalSales) VALUES (?, ?, ?)");
            statement.setInt(1, message.getEmployeeID());
            statement.setFloat(2, message.getCommision());
            statement.setFloat(3, message.getTotalSales());

            statement.execute();
            return Response.ok("User added successfully!").build();
        } catch (SQLException e) {
            System.err.println("Exception while creating employee: " + e);
            return Response.status(400, "Invalid employee data").build();
        }
    }

    @GET
    @Path("/highestSales")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SalesEmployee getMsg() {
        try {

            Connection c = EmployeeDb.getConnection();
            Statement st = c.createStatement();
            PreparedStatement statement = c.prepareStatement("SELECT EmployeeID, TotalSales " +
                    "FROM SalesEmployees " +
                    "WHERE TotalSales = (SELECT MAX(TotalSales) FROM SalesEmployees);");

            ResultSet rs = statement.executeQuery();
            rs.next();
            SalesEmployee emp = new SalesEmployee(rs.getInt("EmployeeID"), rs.getInt("TotalSales"));
            return emp;
        } catch (SQLException e) {
            System.err.println("Exception while getting employee: " + e);
            return null;
        }
    }
}
