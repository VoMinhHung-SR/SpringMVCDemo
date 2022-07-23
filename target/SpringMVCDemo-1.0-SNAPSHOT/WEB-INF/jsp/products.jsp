<%-- 
    Document   : products
    Created on : Jul 22, 2022, 4:21:32 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<c:if test="${errMgs != null}">
    <div class="text-align text-danger">${errMsg}</div>
</c:if>
<c:url value="/admin/products" var="action"/>
<form:form class="container" action="${action}" method="post" modelAttribute="product" 
           enctype="multipart/form-data">

    <form:errors path="*" element="div" cssClass="alert alert-danger"/>

    <div class="form-group">
        <label for="name">Ten san pham</label>
        <form:input type="text" class="form-control" id="name" path="name" placeholder="ten san pham"/>
    </div>

    <div class="form-group">
        <label for="description">Mo ta</label>
        <form:textarea id="description" class="form-control" path="description"/>
    </div>

    <div class="form-group">
        <label for="price">Gia san pham</label>
        <form:input type="text" class="form-control" id="price" path="price" placeholder="gia san pham"/>
    </div>

    <div class="form-group">
        <label for="file">Chon anh san pham</label>
        <form:input type="file" class="form-control" id="file" path="img"/>
    </div>

    <div class="form-group">
        <label for="cate">Danh muc</label>
        <form:select id="cate" path="category" class="form-control">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
