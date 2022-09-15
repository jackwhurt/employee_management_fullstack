const axios = require('axios');

exports.addEmployee = async ( newEmployee ) => {
    console.log( newEmployee )

    try {
        const res = await axios.post('http://localhost:8080/api/employee',
        {
            Name:               newEmployee.name,
            Address:            newEmployee.address,
            Postcode:           newEmployee.postcode,
            StartingSalary:     newEmployee.startingsalary,
            BankNum:            newEmployee.banknumber,
            NIN:                newEmployee.nin,
            Department:         newEmployee.department
        })

    } catch (e) {
        
        return new Error('couldnt add employee')
     }

}

exports.getEmployeeByDept = async (dept) => {

    try {
        const res = await axios.get(`http://localhost:8080/api/Employees/${dept}`)
        return res.data
    } catch(e) {
        return new Error('couldnt find employees')
    }
 }
