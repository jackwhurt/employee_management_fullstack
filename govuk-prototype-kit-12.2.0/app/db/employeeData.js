const axios = require('axios');

exports.addEmployee = async ( newEmployee ) => {
    console.log( newEmployee )

    const res = await axios.post('http://localhost:8080/api/employee',
        {
            Name:               newEmployee.name,
            Address:            newEmployee.address,
            Postcode:           newEmployee.Postcode,
            StartingSalary:     newEmployee.salary,
            BankNum:            newEmployee.banknumber,
            NIN:                newEmployee.nin,
            Department:         newEmployee.department
        })

    return res.insertId;
 }