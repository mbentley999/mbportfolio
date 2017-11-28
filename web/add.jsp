<%-- 
    Document   : add
    Created on : Oct 10, 2017, 1:36:08 PM
    Author     : mattbentley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Videogame</title>
        <link rel = 'stylesheet' type = 'text/css' href = 'hw6.css'/>
    </head>
    <body>
        <div class="wrap">
            <%@ include file="includes/header.jsp"%>
            <%@ include file="includes/menu.jsp"%>   
            
        <div class="main">
        <h1>Add A New Videogame</h1>
        
        <div class="addpage">
        <form name="addForm" action="addFriend" method="get">
            <label>Videogame Name:</label>
            <input type="text" name="name" value="" /><br>
            
            <label>Years Old:</label>
            <input type="text" name="yearsold" value="" /><br>
            
            <label>Gametype:</label>
            <input type="text" name="gametype" value="" /><br>
            
            <label>Rating:</label>
            <input type="text" name="rating" value="" /><br>
        </div>
        <div class="buttons">
            <input type="reset" id="clear" value="Clear">
            <input type="submit" name="submit" value="Submit">
        </div>
        </form>
            </div>
        
            <%@include file="includes/footer.jsp"%>
            
        </div>
    </body>
</html>
