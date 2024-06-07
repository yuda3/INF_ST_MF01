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
            <table class="table table-bordered">
                <tr>
                    <td>Number</td>
                    <td>${book.num}</td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <td>Pager</td>
                    <td>${book.page}</td>
                </tr>
            </table>
            <button class="btn btn-sm btn-primary">List</button>
            <button class="btn btn-sm btn-success">Modify</button>
            <button class="btn btn-sm btn-warning">Delete</button>
        </div>
        <div class="card-footer">Footer</div>
    </div>
</div>

</body>
</html>