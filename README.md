# spring-boot-employee

To work with this api, 
 please use localhost:8080/authenticate url and pass following json object as a body

{
"username" : "employeeapi",
"password" : "password"
}

on successful authentication of this call you will get the token string pass that
Token by adding "Bearer" as a prefix in a Header and then run after :

http://localhost:8080/api/employees/getAll
http://localhost:8080/api/employees/create  (with joson info in body) 
{
        "empId": 333,
        "empName": "prem Pk",
        "empSalary": 200000,
        "empDesignation": "Software dev eng",
        "empDOB": "1991/03/09",
        "empYearsOfExperience": 9
}

Etc....
