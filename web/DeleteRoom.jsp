<%-- 
    Document   : DeleteRoom
    Created on : Jul 4, 2017, 7:43:10 PM
    Author     : sinaj
--%>

<%@page import="com.entity.Rooms"%>
<%@page import="com.bussiness.RoomClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Room</h1>
        <form action="DeleteRoomServlet" method="post">
            <%! RoomClass rc=new RoomClass();%>
            
            <% for(Rooms r:rc.listRooms()){ %>
                <br/>
                code:
                <%=r.getRoomCode() %><br/>
                type:
                <%=r.getRoomType()%><br/>
                Capacity:
                <%=r.getRoomCapacity() %><br/>
                Location:
                <%=r.getRoomLocation() %><br/>
                Cost:
                <%=r.getRoomCost() %>$<br/>
                _________________________________            
            <% } %>
                <br/>
            <h2>Room Code</h2>
                <select name="roomCode" value="rooms code">
                <% for(Rooms r:rc.listRooms()){%>
                <option>
                <%=r.getRoomCode() %>
                </option>
                <% }  %>
                </select>
            <br/>
            <br/>
            <input type="submit" value="Delete"/>
        </form>        
        
    </body>
</html>
