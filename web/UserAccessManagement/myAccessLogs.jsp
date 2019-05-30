<%@page contentType="text/html" import="java.util.*" import="MODEL.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%List<UserAccessLogs> logList = (ArrayList)session.getAttribute("logList");%>

<html>
    <head>
        <title>OMS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Online Movie System</h1>
            <h2>My Access List</h2>
            <hr />
            <form>
                <div class="row">
                    <div class="col-sm-4">
                        <a href="/" class="btn btn-default btn-block">Home</a>
                    </div>
                    <div class="col-sm-3">
                        <input class="form-control" type="search" name="date" placeholder="Enter date search here">        
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" class="btn btn-primary btn-block" value="Search">        
                    </div>
                </div>
            </form>     
            <hr />
            <table class="table table-condensed table-bordered">
                <thead>
                    <tr>
                        <th>Timestamp</th>
                        <th>Access Type</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%for (UserAccessLogs l : logList){%>
                    <tr>
                        <td><%=l.getTimeStamp()%></td>
                        <td><%=l.getAccessType()%></td>
                        <td>
                            <form method="post" action="/deleteLogs">
                                <input type="hidden" name="id" value="<%=l.getID()%>" />
                                <input type="submit" class="btn btn-xs btn-danger" value="Delete" />
                            </form>
                        </td>
                    </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
