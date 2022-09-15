const express = require('express')
const router = express.Router()

const employeeData = require('./db/employeeData');

// Add your routes here - above the module.exports line

router.get('/add-employee-form', async (req, res) => {

  res.render('add-employee-form')
});

router.post('/add-employee', async (req, res) => {

  var employee = req.body;

  let result = await employeeData.addEmployee( employee );

  console.log(result)

  if ( result != 200 ) {
    res.locals.errormessage = "please check your fields again."
    res.render('add-employee-form', req.body)
  } else {
    res.locals.successmessage = "the employee has been added!"
    res.render('add-employee-form', )
  }
});

router.get('/get-employees-by-dept', async (req,res) => {

  var dept = req.query.department
  res.locals.dept = dept
  res.render('list-employees', {employees: await employeeData.getEmployeeByDept(dept)})

})





module.exports = router
