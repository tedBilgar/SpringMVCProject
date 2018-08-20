<%--
  Created by IntelliJ IDEA.
  User: s_user05
  Date: 15.08.2018
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX IMPLEMENTATION</title>
</head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function ($) {
            $("#ajaxForm").submit(function (event) {

                event.preventDefault();
                //alert("HERE" + $("#name").val());
                RestPost();
            });
            $("#ajaxFormSelect").submit(function (event) {
                event.preventDefault();
                RestSelect();
            })
        });



        var prefix = '/rest';

        var RestGet = function() {
            $.ajax({
                type: 'GET',
                url:  prefix + '/findAll',
                async: true,
                success: function (result) {
                    var products;
                    $.each(result,function (index) {
                       //alert(result[index].name);
                       products += "Product "+index + ": " +  result[index].name + ";price :" + result[index].price+
                        " weight: " + result[index].weight+ "<br>";
                    });
                    $("#getResponse").html(products);
                }
            });
        }

        var RestPost = function() {
            var JSONObject = {}
            JSONObject["name"] = $("#name").val();
            JSONObject["price"] = $("#price").val();
            JSONObject["weight"]= $("#weight").val();

            $.ajax({
                type: 'POST',
                url:  prefix + "/add",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(JSONObject),
                dataType: 'json',
                async: true,
                success: function(result) {
                    /*alert('Время: ' + result.time
                        + ', сообщение: ' + result.message);*/
                    RestGet();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    /*alert(jqXHR.status + ' ' + jqXHR.responseText);*/
                }
            });
        }

        var RestSelect = function() {
            $.ajax({
                type: 'GET',
                url:  prefix + "/select?price=" + $("#wishedPrice").val()+"&weight=" + $("#wishedWeight").val(),
                dataType: 'json',
                async: true,
                success: function(result) {
                    var selectProducts;
                    $.each(result,function (index) {
                        selectProducts += "Product "+index + ": " +  result[index].name + ";price :" + result[index].price+
                            " weight: " + result[index].weight+ "<br>";
                    });
                    $("#getSelectProducts").html(selectProducts);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                }
            });
        }
    </script>
<body>

<h3> Аналог веб-сервиса для выбора продуктов на AJAX</h3>

    <button type="button" onclick="RestGet()">Получить полный список</button>
    <h1> All products</h1>
    <div id="getResponse"></div>

    <form id ="ajaxForm">
        <p>
            <label for="name">Name</label>
            <input type="text" id="name" name="name"/>
        </p>
        <p>
            <label for="price">price</label>
            <input type="text" id="price" name="price" />
        </p>
        <p>
            <label for="weight">weight</label>
            <input type="text" id="weight" name="weight" />
        </p>

        <button type="submit">Добавить</button>
    </form>
<h2>Желаемые товары по вашему выбору</h2>
<div id="getSelectProducts"></div>
<form id ="ajaxFormSelect">
    <p>
        <label for="wishedPrice"> Wished Price</label>
        <input type="text" id="wishedPrice" name="wishedPrice" />
    </p>
    <p>
        <label for="wishedWeight">Wished weight</label>
        <input type="text" id="wishedWeight" name="wishedWeight" />
    </p>

    <button type="submit">Выбрать</button>
</form>
</body>
</html>
