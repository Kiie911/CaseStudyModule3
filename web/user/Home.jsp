<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/29/2020
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Các Trường Đại Học</title>
</head>
<body>
<div class="container">

    <h1 class="font-weight-light text-center text-lg-left mt-4 mb-0">Making Friends</h1>
    <hr class="mt-2 mb-5">
    <div>
        <p>Xin chào ${requestScope.acount}</p>
    </div>

    <div class="row text-center text-lg-left">
            <div  style="float: left" class="col-lg-3 col-md-4 col-6" id="BKA">
                <p>Đại học Bách Khoa HN</p>
                <a href="/users?action=showListBKA"  class="d-block mb-4 h-100" >
<%--                    <input class="img-fluid" name="list" id="list" type="image" value="BKA" src="https://media.kenhtuyensinh.vn/images/cms/2019/08/diem-chuan-dh-bach-khoa-hn-2019-1.jpg">--%>
                    <img class="img-fluid img-thumbnail" src="https://media.kenhtuyensinh.vn/images/cms/2019/08/diem-chuan-dh-bach-khoa-hn-2019-1.jpg" alt="">
                </a>
            </div>

        <div style="float: left"class="col-lg-3 col-md-4 col-6" id="KT">
            <p>Đại học Kinh Tế Quốc Dân</p>
            <a href="/users?action=showListKT" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="https://kenh14cdn.com/2017/11-1502881146043.png" alt="">
            </a>
        </div>
        <div style="float: left" class="col-lg-3 col-md-4 col-6" id="XD">
            <p>Đại học Xây Dựng</p>
            <a href="/users?action=showListXD" class="d-block mb-4 h-100">
                <img class="img-fluid img-thumbnail" src="http://www.nuce.edu.vn/sites/default/files/image001.jpg" alt="">
            </a>
        </div>
    </div>
    <div>
        <a href=""> Yêu cầu kết bạn</a>
        <a href=""> Danh sách bạn bè</a>
    </div>
    <div>
        <a href="/users?action=edit&acount=${requestScope.acount}"> Chỉnh sửa thông tin</a>
    </div>
</div>
<style>
    .container div{
        margin: 45px;
    }
     .img-fluid{
        width: 400px;
        height: 300px;
    }
    /*.text-field{*/
    /*    position: relative;*/
    /*    left: 30px;*/
    /*}*/
</style>
</body>
</html>
