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

  if ( !result ) {
    res.locals.errormessage = "please check your fields"
    res.render('add-employee-form', req.body)
  }
});



module.exports = router
