const axios = require('axios');

exports.addSalesEmployee = async ( newSalesEmployee ) => {
    console.log( newSalesEmployee )

    try {
        const res = await axios.post('http://localhost:8080/api/salesEmployee',
        {
            EmployeeID:     newSalesEmployee.id,
            Commision:      newSalesEmployee.commission,
            TotalSales:     newSalesEmployee.totalsales
        })

        return res.status;

    } catch (e) {
        
        return new Error('couldnt add sales employee')
     }
}