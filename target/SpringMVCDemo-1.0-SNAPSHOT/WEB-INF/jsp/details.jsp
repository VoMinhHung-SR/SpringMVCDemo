<%-- 
    Document   : details
    Created on : Jul 18, 2022, 1:36:23 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center">Chi tiet san pham</h1>
<div style=" margin: 0 auto">
    <div id="${product.id}" class="card" style="width: 30%; margin: 20px auto; display: flex">
        <c:url value="" var="productImg"/>
        <img src="https://cdn.tgdd.vn/Products/Images/42/153856/TimerThumb/iphone-11-(48).jpg" class="card-img-top" alt="${p.name}">
        <div class="card-body">
            <h5 class="card-title">${product.name}</h5>
            <p class="card-text">${product.description}</p>
            <p class="card-text">${product.price} VND</p>
            <a href="<c:url value="/cart" />" class="btn btn-primary">Them vao gio</a>
        </div>
    </div>

</div>