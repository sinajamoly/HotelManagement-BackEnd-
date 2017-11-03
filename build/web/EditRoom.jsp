<%-- 
    Document   : EditRoom
    Created on : Jul 4, 2017, 6:27:11 PM
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
        <form action="EditRoomServlet" method="post">
        <h1>Edit Room</h1>
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
            <h2>Room Type</h2>
            <select name="roomType">
                                <option>Normal</option>
                                <option>Excelent</option>
                                <option>VIP</option>
                                <option>VVIP</option>
            </select>
            <h2>Room Capacity</h2>
            <select name="roomCapacity">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
            </select>
            <h2>Room Location</h2>
            <select name="roomLocation">
                                <option>Building_one</option>
                                <option>Building_Two</option>
                                <option>Bulding_Three</option>
            </select>
            <h2>Room Cost</h2>
            <input type="text" name="roomCost"/>
            <br/>
            <input type="submit" value="Edit"/>
        </form>
            
    </body>
</html>
