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

exports.highestSalesEmployee = async () => {

    try {

        const res = await axios.get('http://localhost:8080/api/highestSales')

        return res;
    } catch (e) {

        return new Error ('couldnt return highest sales employee')
    }
}