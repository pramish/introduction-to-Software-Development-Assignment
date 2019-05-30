<%-- 
    Document   : createUser
    Created on : 08/05/2019, 5:58:50 PM
    Author     : pramishluitel
--%>

<%@page import="MODEL.DAO.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.controller.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>OMS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Create User</h1>
        <div class="container-fluid">
            <div class="col-sm-12 text-center">
                <button class="btn btn-primary btn-lg active" name="home" onclick="location.href = 'index.jsp';">Home</button>
            </div>
        </div>
        <br><br>
        <form action="/createUser" method="POST">
            <div class="form-row">
                <div class="col-md-4 mb-3">

                    <label for="validationDefault01">Full Name</label>
                    <input type="text" class="form-control" id="validationDefault01" placeholder="enter the full name" name="fullName">
                </div>
                <div class="col-md-4 mb-3">

                    <label for="validationDefault02">Email Address</label>
                    <input type="text" class="form-control" id="validationDefault02" placeholder="enter the email address" name="email">
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 mb-3">

                    <label for="validationDefault03">Password</label>
                    <input type="password" class="form-control" id="validationDefault03" placeholder="enter the password" name="password">
                </div>
                <div class="col-md-3 mb-3">

                    <label for="validationDefault05">Phone Number</label>
                    <input type="text" class="form-control" id="validationDefault05" placeholder="enter the phone number" name="phoneNumber">
                </div>
            </div>
            <br><br><br><br><br><br><br><br>
            <div class="container-fluid">
                <div class="col-sm-12 text-center">
                    <button class="btn btn-primary btn-lg active" type="submit" name="submit">Create User</button>
                </div>
            </div>
        </form>

    </body>
</html>
