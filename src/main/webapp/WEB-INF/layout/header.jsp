<%-- 
    Document   : header
    Created on : Jul 16, 2022, 12:03:04 AM
    Author     : ASUS
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
      <a class="navbar-brand" href="<c:url value="/" />">Home</a>
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarTogglerDemo02"
      aria-controls="navbarTogglerDemo02"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <c:forEach var="i" items="${categories}">
            <li class="nav-item">
                <a class="nav-link" href="#" style="color: white">${i.name}</a> 
            </li>
        </c:forEach>
        <li class="nav-item">
          <a class="nav-link disabled"
            >Disabled</a
          >
        </li>
      </ul>
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
    </div>
  </div>
</nav>


