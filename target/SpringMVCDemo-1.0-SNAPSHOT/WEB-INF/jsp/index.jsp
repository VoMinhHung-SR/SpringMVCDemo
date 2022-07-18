<%-- 
    Document   : index
    Created on : Jul 9, 2022, 12:17:03 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<h1 class="text-center">Trang chu</h1>

<div style="display: flex; flex-wrap: wrap; margin: 0 auto">
    <c:forEach var="p" items="${products}">
    <div id="${p.id}" class="card" style="width: 30%; margin: 20px auto ">
        <c:url value="" var="productImg"/>
        <img src="https://cdn.tgdd.vn/Products/Images/42/153856/TimerThumb/iphone-11-(48).jpg" class="card-img-top" alt="${p.name}">
        <div class="card-body">
            <h5 class="card-title">${p.name}</h5>
            <p class="card-text">${p.description}</p>
            <p class="card-text"><fmt:formatNumber  value="${p.price}" maxFractionDigits="3" type="number"/> VND</p>
            <a href="<c:url value="/cart" />" class="btn btn-primary">Them vao gio</a>
            <a href="<c:url value="/products/${p.id}" />" class="btn btn-success">Xem chi tiet</a>
        </div>
    </div>
</c:forEach>

</div>


