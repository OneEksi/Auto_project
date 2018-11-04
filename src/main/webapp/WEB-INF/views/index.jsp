<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <%--<script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>--%>
  <%--<script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js"></script>--%>
  <%--<script src="https://cdn.anychart.com/releases/v8/js/anychart-vml.min.js"></script>--%>
  <%--<link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css" />--%>
  <%--<link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/fonts/css/anychart.min.css"/>--%>
  <link rel="stylesheet" href="/resources/css/style.css" />
  <title>Convert JSON Data to HTML Table</title>
    <script>
        function GetJson(id) {

            var xmlhttp = new XMLHttpRequest();
             var url = "http://localhost:8080/java-jsp-jdbc-mysql-auto/view?t="+id;

            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var myArr = JSON.parse(this.responseText);
                    //myFunction(myArr);
                    CreateTableFromJSON(myArr);
                }
            };
            xmlhttp.open("GET", url, true);
            xmlhttp.send();
        }
        // function myFunction(arr) {
        //     var out = "";
        //     var i;
        //     for(i = 0; i < arr.length; i++) {
        //         out += '<a href="' + arr[i].url + '">' +
        //             arr[i].display + '</a><br>';
        //     }
        //     document.getElementById("id01").innerHTML = out;
        // }
        function CreateTableFromJSON(jsondate) {
            //var jsondate =${chartData}
            var col = [];
            for (var i = 0; i < jsondate.length; i++) {
                for (var key in jsondate[i]) {
                    if (col.indexOf(key) === -1) {
                        col.push(key);
                    }
                }
            }

            // CREATE DYNAMIC TABLE.
            var table = document.createElement("table");

            // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

            var tr = table.insertRow(-1);                   // TABLE ROW.

            for (var i = 0; i < col.length; i++) {
                var th = document.createElement("th");      // TABLE HEADER.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }

            // ADD JSON DATA TO THE TABLE AS ROWS.
            for (var i = 0; i < jsondate.length; i++) {

                tr = table.insertRow(-1);

                for (var j = 0; j < col.length; j++) {
                    var tabCell = tr.insertCell(-1);
                    tabCell.innerHTML = jsondate[i][col[j]];
                }
            }

            // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
            var divContainer = document.getElementById("showData");
            divContainer.innerHTML = "";
            divContainer.appendChild(table);
        }
    </script>
  <style>
    body { background: url("../../resources/images/car-logos.jpg"); }
    th, td, p, input {
      font:14px Verdana;
    }
    table, th, td
    {
      margin: auto ;
      border: solid 3px #e0d666;
      border-collapse: collapse;
      padding: 2px 3px ;
      text-align: center;



    }
    th {
      font-weight:bold;
    }
  </style>
</head>
<body>
<input type="button" onclick="GetJson(0);" value="Car Model" />
<input type="button" onclick="GetJson(1);" value="Customers" />
<input type="button" onclick="GetJson(2);" value="Employees" />
<input type="button" onclick="GetJson(3);" value="Employees Statistics" />
<input type="button" onclick="GetJson(4);" value="Sales" />

<p id="showData"></p>

</body>

</html>