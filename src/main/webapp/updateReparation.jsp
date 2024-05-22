<%@ page import="edu.hneu.mjt.kuznecsemen.lab4.entity.PhoneReparationInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Phone Reparation Info</h2>
<%
    var reparation = (PhoneReparationInfo) request.getAttribute("reparation");
    if (reparation != null) {
%>
<form action="edit-reparation" method="post">
    <input type="hidden" name="id" value="<%= reparation.getId() %>">
    <label>Title: <input required type="text" name="title" value="<%= reparation.getTitle() %>"></label><br>
    <label>Manufacturer: <input required type="text" name="manufacturer"
                                value="<%= reparation.getManufacturer() %>"></label><br>
    <label>Model: <input required type="text" name="model" value="<%= reparation.getModel() %>"></label><br>
    <label>Platform: <input required type="text" name="platform" value="<%= reparation.getPlatform() %>"></label><br>
    <label>Camera: <input type="checkbox" name="camera" <%= reparation.isCamera() ? "checked" : "" %>></label><br>
    <label>Internet: <input required type="text" name="internet" value="<%= reparation.getInternet() %>"></label><br>
    <label>GPS Module: <input type="checkbox" name="gpsModule" <%= reparation.isGpsModule() ? "checked" : "" %>></label><br>
    <label>Recorder: <input type="checkbox" name="recorder" <%= reparation.isRecorder() ? "checked" : "" %>></label><br>
    <label>Price: <input required type="number" name="price" value="<%= reparation.getPrice() %>"></label><br>
    <label>Opt Price: <input required type="number" name="optPrice" value="<%= reparation.getOptPrice() %>"></label><br>
    <label>User Last Name: <input required type="text" name="userLastName" value="<%= reparation.getUserLastName() %>"></label><br>
    <label>User Email: <input required type="email" name="userEmail"
                              value="<%= reparation.getUserEmail() %>"></label><br>
    <input type="submit" value="Submit">
</form>
<%
} else {
%>
<h2>NOT FOUND</h2>
<%
    }
%>
</body>
</html>
