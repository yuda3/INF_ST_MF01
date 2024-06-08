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
</head>
<body>

<div class="container">
    <h2>Card Header and Footer</h2>
    <div class="card">
        <div class="card-header">Header</div>
        <div class="card-body">
            <form action="/MF01/updatePost.do" method="post">
                <input type="hidden" name="num" id="num" value="${book.num}"/>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title" value="${book.title}">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" name="price" value="${book.price}">
                </div>
                <div class="form-group">
                    <label for="author">Author:</label>
                    <input type="text" class="form-control" id="author" name="author" value="${book.author}">
                </div>
                <div class="form-group">
                    <label for="page">Page:</label>
                    <input type="text" class="form-control" id="page" name="page" value="${book.page}">
                </div>
                <button type="submit" class="btn btn-sm btn-primary">Update</button>
                <button type="reset" class="btn btn-sm btn-danger">Cancel</button>
                <button type="button" class="btn btn-sm btn-info" onclick="location.href='/MF01/list.do'">List</button>
            </form>
        </div>
        <div class="card-footer">Footer</div>
    </div>
</div>

</body>
</html>