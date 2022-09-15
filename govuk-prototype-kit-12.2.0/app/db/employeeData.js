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

        return res.status

    } catch (e) {
        
        return new Error('couldnt add employee')
     }

}

exports.getEmployeeByDept = async (dept) => {

    try {
        const res = await axios.get(`http://localhost:8080/api/employees/${dept}`)
        return res.data
    } catch(e) {
        return new Error('couldnt find employees')
    }
 }

 exports.getFinanceReport = async () => {

    try {
        const res = await axios.get(`http://localhost:8080/api/finance-report`)
        console.log(res.data)
        return res.data
    } catch(e) {
        return new Error('couldnt find employees')
    }
 }