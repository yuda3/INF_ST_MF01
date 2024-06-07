<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function goDel(num){
            location.href="/MF01/delete?num="+num;
        }
        function goRegister(){
            location.href="/MF01/registerGet";
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Web Database Programming</h2>
    <div class="card">
        <div class="card-header">Book List</div>
        <div class="card-body">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>number</th>
                    <th>title</th>
                    <th>price</th>
                    <th>author</th>
                    <th>pages</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.num}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.page}</td>
                    <td><button class="btn btn-sm btn-warning" onclick="goDel(${book.num})">Delete</button></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <button class="btn btn-sm btn-primary" onclick="goRegister()">Register</button>
        </div>
        <div class="card-footer">MK01</div>
    </div>
</div>

</body>
</html>