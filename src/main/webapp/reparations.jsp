<%@ page import="edu.hneu.mjt.kuznecsemen.lab4.entity.PhoneReparationInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phone Reparation Info</title>
</head>
<body>
<a href="about.jsp">About</a>
<h1>Phone Reparation Info</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Manufacturer</th>
        <th>Model</th>
        <th>Platform</th>
        <th>Camera</th>
        <th>Internet</th>
        <th>GPS Module</th>
        <th>Recorder</th>
        <th>Price</th>
        <th>Opt Price</th>
        <th>User Last Name</th>
        <th>User Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<PhoneReparationInfo> reparations = (List<PhoneReparationInfo>) request.getAttribute("reparations");
        if (reparations != null) {
            for (var reparation : reparations) {
    %>
    <tr>
        <td><%= reparation.getId() %></td>
        <td><%= reparation.getTitle() %></td>
        <td><%= reparation.getManufacturer() %></td>
        <td><%= reparation.getModel() %></td>
        <td><%= reparation.getPlatform() %></td>
        <td><%= reparation.isCamera() %></td>
        <td><%= reparation.getInternet() %></td>
        <td><%= reparation.isGpsModule() %></td>
        <td><%= reparation.isRecorder() %></td>
        <td><%= reparation.getPrice() %></td>
        <td><%= reparation.getOptPrice() %></td>
        <td><%= reparation.getUserLastName() %></td>
        <td><%= reparation.getUserEmail() %></td>
        <td>
            <div>
                <a style="color: blue;" href="delete-reparation?id=<%= reparation.getId() %>">Delete</a>
            </div>
            <div>
                <a style="color: blue;" href="edit-reparation?id=<%= reparation.getId() %>">Edit</a>
            </div>
        </td>
    </tr>
    <% }
    } %>
    </tbody>
</table>

<h2>Add New Phone Reparation Info</h2>
<form action="add-reparation" method="post">
    <label>Title: <input required type="text" name="title"></label><br>
    <label>Manufacturer: <input required type="text" name="manufacturer"></label><br>
    <label>Model: <input required type="text" name="model"></label><br>
    <label>Platform: <input required type="text" name="platform"></label><br>
    <label>Camera: <input type="checkbox" name="camera"></label><br>
    <label>Internet: <input required type="text" name="internet"></label><br>
    <label>GPS Module: <input type="checkbox" name="gpsModule"></label><br>
    <label>Recorder: <input type="checkbox" name="recorder"></label><br>
    <label>Price: <input required type="number" name="price"></label><br>
    <label>Opt Price: <input required type="number" name="optPrice"></label><br>
    <label>User Last Name: <input required type="text" name="userLastName"></label><br>
    <label>User Email: <input required type="email" name="userEmail"></label><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

