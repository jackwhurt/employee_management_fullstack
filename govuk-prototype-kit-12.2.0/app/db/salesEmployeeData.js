const axios = require('axios');

exports.addSalesEmployee = async ( newSalesEmployee ) => {
    console.log( newSalesEmployee )

    try {
        const res = await axios.post('http://localhost:8080/api/employee',
        {
            Name:               newSalesEmployee.name,
            Address:            newSalesEmployee.address,
            Postcode:           newSalesEmployee.postcode,
            StartingSalary:     newSalesEmployee.startingsalary,
            BankNum:            newSalesEmployee.banknumber,
            NIN:                newSalesEmployee.nin,
            Department:         "sales",
            Commision:          newSalesEmployee.commision,
            TotalSales:         newSalesEmployee.totalsales
        })

        return res.status;

    } catch (e) {
        
        return new Error('couldnt add sales employee')
     }
}