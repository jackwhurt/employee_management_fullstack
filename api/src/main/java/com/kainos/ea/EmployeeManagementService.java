package com.kainos.ea;

import com.kainos.ea.db.GetEmployeeByDept;
import com.kainos.ea.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class EmployeeManagementService {

    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @GET
    @Path("/Employees/{dept}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesByDept(String dept) {

        List<Employee> myEmployees = GetEmployeeByDept.execute(dept);
        return myEmployees;

    }
}
