<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Videogames"%>
<% Videogames videogame = (Videogames) request.getAttribute("videogame"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a Videogame</title>
        <link rel = 'stylesheet' type = 'text/css' href = 'hw6.css'/>
    </head>
    <body>
        <div class="wrap">
            <%@ include file="includes/header.jsp"%>
            <%@ include file="includes/menu.jsp"%>   
            
        <div class="main">
        <h1>Update A Videogame</h1>
        
        <div class="addpage">
        <form name="updateForm" action="updateFriend" method="get">
            <label class="center">Videogame ID:</label>
            <input type="text" name="vid" value="<%= videogame.getV_id() %>" readonly/>  
            <label class="warning">Videogame ID cannot be changed, to keep data integrity</label><br>
            
            <label>Videogame Name:</label>
            <input type="text" name="name" value="<%= videogame.getV_name() %>" /><br>
            
            <label>Years Old:</label>
            <input type="text" name="yearsold" value="<%= videogame.getYears_old() %>" /><br>
            
            <label>Gametype:</label>
            <input type="text" name="gametype" value="<%= videogame.getGame_type() %>" /><br>
            
            <label>Rating:</label>
            <input type="text" name="rating" value="<%= videogame.getRating() %>" /><br>
        </div>
        <div class="buttons">
            <input type="reset" id="clear" value="Reset to Previous">
            <input type="submit" name="submit" value="Update">
        </div>
        </form>
        </div>
        
            <%@include file="includes/footer.jsp"%>
            
        </div>
    </body>
</html>
