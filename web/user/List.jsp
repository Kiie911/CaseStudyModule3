<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/23/2020
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<center>
    <h1>Danh sách sinh viên</h1>
</center>
<div align="center">
    <table border="0" cellpadding="20">
        <tr>
            <th>Acount</th>
            <th>Mail</th>
            <th>Address</th>
            <th>Birthday</th>
            <th>Sex</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.acount}"/></td>
                <td><c:out value="${user.mail}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td><c:out value="${user.birthday}"/></td>
                <td><c:out value="${user.sex}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Kết Bạn</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/users?action=checkLogin">Back</a>
</div>
<style>
    table{
        border-collapse: collapse;
    }
    tr th, tr td {
        border: 1px solid;
    }
</style>
</body>
</html>
