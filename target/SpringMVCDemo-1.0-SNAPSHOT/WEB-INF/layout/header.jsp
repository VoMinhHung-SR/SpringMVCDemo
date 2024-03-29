<%-- 
    Document   : header
    Created on : Jul 16, 2022, 12:03:04 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">SaleApp</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
            </li>
            <c:forEach items="${categories}" var="c">
                <li class="nav-item">
                    <c:url value="/" var="cateUrl" >
                        <c:param name="cateId" value="${c.id}" />
                    </c:url>
                    <a class="nav-link" href="${cateUrl}">${c.name}</a>
                </li>
            </c:forEach>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link  text-danger" href="<c:url value="/login" />">Dang nhap</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/register" />">Dang ky</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/logout" />">Dang xuat</a>
                </li>
            </c:if>

        </ul>
    </div>
    <form class="d-flex input-group w-auto">
        <input
            name="kw"
            type="search"
            class="form-control"
            placeholder="Type query"
            aria-label="Search"
            />
        <input type="submit" value="Search" class="btn btn-danger">
    </form>
</nav>

