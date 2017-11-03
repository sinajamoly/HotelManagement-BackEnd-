<%@page import="com.entity.Rooms"%>
<%@page import="com.bussiness.RoomClass"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : BookRoom
    Created on : Jul 4, 2017, 1:25:30 AM
    Author     : sinaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book Room</h1>
        <h1>${requestScope["message"]}</h1>
        <%! RoomClass rc=new RoomClass(); %>
        <form action="BookRoomServlet" method="submit">
            <h4>Room Code</h4>
            <select name="roomCode" value="rooms code">
                <% for(Rooms r:rc.listRooms()){%>
                <option>
                <%=r.getRoomCode() %>
                </option>
        <% }  %>
            </select>
            
            <table border="1">
                <tbody>
                    <tr>
                        <td>Check In</td>
                        <td><input type="date" name="checkIn" value="" /></td>
                    </tr>
                    <tr>
                        <td>Check Out</td>
                        <td><input type="date" name="checkOut" value="" /></td>
                    </tr>
                    <tr>
                        <td>paid Status</td>
                        <td><input type="checkbox" name="paid" value="ON" /></td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <input type="submit" value="Book the Room"/>
        </form>
            
          <br/>
          <br/>
          <h2>List of the Rooms</h2>
        <form>
            <table border="1">
                <thead>
                    <tr>
                        <th>code</th>
                        <th>type</th>
                        <th>Capacity</th>
                        <th>Location</th>
                        <th>Cost</th>
                    </tr>
                </thead>
                <tbody>
            <% for(Rooms r:rc.listRooms()){%>
                    <tr>
                        <td><%=r.getRoomCode() %><br/></td>
                        <td><%=r.getRoomType()%><br/></td>
                        <td><%=r.getRoomCapacity() %><br/></td>
                        <td><%=r.getRoomLocation() %></td>
                        <td><%=r.getRoomCost() %></td>
                    </tr>
            <% }  %>
               </tbody>
            </table>
        </form>
    </body>
</html>
