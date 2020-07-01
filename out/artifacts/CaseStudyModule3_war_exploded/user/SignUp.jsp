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
            <legend class="">Register</legend>
        </div>
        <div class="control-group">
            <!-- Acount -->
            <label class="control-label"  for="acount">Username</label>
            <div class="controls">
                <input type="text" id="acount" name="acount" placeholder="" class="input-xlarge">
                <p class="help-block">Username can contain any letters or numbers, without spaces</p>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <label class="control-label" for="mail">E-mail</label>
            <div class="controls">
                <input type="text" id="mail" name="mail" placeholder="" class="input-xlarge">
                <p class="help-block">Please provide your E-mail</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                <p class="help-block">Password should be at least 4 characters</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password -->
            <label class="control-label"  for="password_confirm">Password (Confirm)</label>
            <div class="controls">
                <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
                <p class="help-block">Please confirm password</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Address -->
            <label class="control-label" for="address">Address</label>
            <div class="controls">
                <input type="text" id="address" name="address" placeholder="" class="input-xlarge">
                <p class="help-block">Please provide your Addressl</p>
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
                <p class="help-block">Please provide your Sex</p>
            </div>
        </div>

        <div class="control-group">
        <!-- birthday -->
        <label class="control-label" for="birthday">birthday</label>
        <div class="controls">
            <input type="text" id="birthday" name="birthday" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide your Birthday</p>
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
                <p class="help-block">Please provide your Sex</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <input type="submit" value="Register">
                <a href="/users">Login</a>
            </div>
        </div>
    </fieldset>
</form>