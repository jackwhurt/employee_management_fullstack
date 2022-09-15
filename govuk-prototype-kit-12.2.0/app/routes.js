const express = require('express')
const router = express.Router()

const employeeData = require('./db/employeeData');
const salesEmployeeData = require('./db/salesEmployeeData');

// Add your routes here - above the module.exports line

router.get('/add-employee-form', async (req, res) => {

  res.render('add-employee-form')
});

router.post('/add-employee', async (req, res) => {

  var employee = req.body;

  let result = await employeeData.addEmployee( employee );

  if ( result != 200 ) {
    res.locals.errormessage = "please check your fields again."
    res.render('add-employee-form', req.body)
  } else {
    res.locals.successmessage = "the employee has been added!"
    res.render('index')
  }
});

router.get('/add-sales-employee-form', async (req, res) => {

  res.render('add-sales-employee-form')
});

router.post('/add-sales-employee', async (req, res) => {

  var employee = req.body;

  let result = await salesEmployeeData.addSalesEmployee( employee );

  if ( result != 200 ) {
    res.locals.errormessage = "please check your fields again."
    res.render('add-sales-employee-form', req.body)
  } else {
    res.locals.successmessage = "the sales employee has been added!"
    res.render('index')
  }
}) 

router.get('/get-employees-by-dept', async (req,res) => {

  var dept = req.query.department
  res.locals.dept = dept
  res.render('list-employees', {employees: await employeeData.getEmployeeByDept(dept)})
  
})

router.get('/get-employees-by-dept', async (req,res) => {

  var dept = req.query.department
  res.locals.dept = dept
  res.render('list-employees', {employees: await employeeData.getEmployeeByDept(dept)})
  
})

module.exports = router
