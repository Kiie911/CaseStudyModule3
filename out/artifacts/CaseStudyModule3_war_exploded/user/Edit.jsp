<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/26/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<form class="form-horizontal" action='' method="POST">
    <fieldset>
        <div id="legend">
            <legend class="">Edit Acount</legend>
        </div>

        <c:if test="${user != null}">
            <input type="hidden" name="acount" value="<c:out value='${user.acount}' />"/>
        </c:if>

        <div>
            <p><c:out value='${user.acount}' /></p>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="mail">E-mail</label>
            <div class="controls">
                <input type="text" id="mail" name="mail" placeholder="<c:out value='${user.mail}' />">
                <p>Please provide your E-mail</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" >
                <p>Password should be at least 4 characters</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password -->
            <label class="control-label"  for="password_confirm">Password (Confirm)</label>
            <div class="controls">
                <input type="password" id="password_confirm" name="password_confirm" placeholder="">
                <p>Please confirm password</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Address -->
            <label class="control-label" for="address">Address</label>
            <div class="controls">
                <input type="text" id="address" name="address" placeholder="<c:out value='${user.address}' />">
                <p>Please provide your Addressl</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Giới tính -->
            <label class="control-label" for="sex">Giới tính</label>
            <div class="controls">
                <%--                <input type="text" id="birthday" name="birthday" placeholder="" class="input-xlarge">--%>
                <select name="sex" id="sex">
                    <option value="nam">Nam</option>
                    <option value="nu">Nữ</option>
                    <option value="3d">3D</option>
                </select>
                <p>Please provide your Sex</p>
            </div>
        </div>

        <div class="control-group">
            <!-- birthday -->
            <label class="control-label" for="birthday">birthday</label>
            <div class="controls">
                <input type="text" id="birthday" name="birthday" placeholder="<c:out value='${user.birthday}' />">
                <p>Please provide your Birthday</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Giới tính -->
            <label class="control-label" for="university">University</label>
            <div class="controls">
                <%--                <input type="text" id="birthday" name="birthday" placeholder="" class="input-xlarge">--%>
                <select name="university" id="university">
                    <option value="BKA">Bách Khoa</option>
                    <option value="KT">Kinh tế</option>
                    <option value="XD">Xây dựng</option>
                </select>
                <p>Please provide your Sex</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <input type="submit" value="Save">
                <a href="/user/Home.jsp">Back</a>
            </div>
        </div>
    </fieldset>
</form>