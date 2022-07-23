<%-- 
    Document   : login
    Created on : Jul 23, 2022, 10:12:37 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Da xay ra loi
    </div>
</c:if>
<h1 class="text-center text-danger"> Dang nhap </h1>
<c:url var="action" value="/login"/>
<form  action="${action}" method="post">

    <div class="form-group">
        <label for="username">Nhap Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="nhap username"/>
    </div>

    <div class="form-group">
        <label for="password">Nhap Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="nhap password"/>
    </div>
    

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
    
