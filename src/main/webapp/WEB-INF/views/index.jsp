<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="/resources/css/style.css" />
  <title>Convert JSON Data to HTML Table</title>
    <script src="resources/scripts/NecessaryScripts.js">
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
<input type="button" onclick="CreateDropdown();" value="ADD" />
<input type="button" onclick="CreateDropdown();" value="Sales" />

</body>

</html>