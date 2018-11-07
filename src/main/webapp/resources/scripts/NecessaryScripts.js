var tableId =0;
var columnNames =[];
function GetJson(id) {

    var xmlhttp = new XMLHttpRequest();
    var url = "view?t="+id;

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            //myFunction(myArr);
            CreateTableFromJSON(myArr,id);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function CreateTableFromJSON(jsondate,id) {
    //var jsondate =${chartData}
    var col = [];
    for (var i = 0; i < jsondate.length; i++) {
        for (var key in jsondate[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
columnNames =col;
    tableId=id;
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

function UpdateTable (content)
{
//Send data to server to update table
    var xmlhttp = new XMLHttpRequest();
    var url = "update";

    xmlhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
           //alert("ok");
            GetJson(tableId);
        }

    };
    
    var data = {"tableId": tableId,"content":content};
    xmlhttp.open("POST", url, true);
    xmlhttp.send(JSON.stringify(data));
}
function CreateDropdown()

{
    var dd = document.createElement("div");
    dd.id="ddmenu";
    dd.className="panel panel-success";
    var p_header = document.createElement("div");
    p_header.className="panel-heading";
    p_header.innerHTML="Add";
    var p_body = document.createElement("div");



    for (var i =0; i<columnNames.length;i++){
       var el = document.createElement("p");
       el.innerHTML= columnNames[i] ;
       var text = document.createElement("input");
       text.type="text";
       text.id =columnNames[i];
       el.appendChild(text);
       p_body.appendChild(el);
    }

    var button = document.createElement("input");
    button.type = "button";
    button.value = "Apply";
    button.className="btn btn-xs btn-primary";
    button.onclick =function(){
        var colNV = {};
        for (var key in columnNames) {
            colNV[columnNames[key]] = document.getElementById(columnNames[key]).value;

        }
        UpdateTable(colNV);

    };
    p_body.appendChild(button);
    dd.appendChild(p_header);
    dd.appendChild(p_body);

    //dd.appendChild(ul);
   var eldd= document.getElementById(dd.id) ;
   if (eldd === null){
       document.getElementsByTagName("body")[0].appendChild(dd);
   } else {
       //eldd.innerHTML = "";
       var pe= eldd.parentElement;
       pe.removeChild(eldd);
       pe.appendChild(dd);
       //eldd.appendChild(dd);}
   }

   }

   function DeleteRow(idRow) {
       var xmlhttp = new XMLHttpRequest();
       var url = "deleterow";

       xmlhttp.onreadystatechange = function () {
           if (this.readyState === 4 && this.status === 200) {
               //alert("ok");
               GetJson(tableId);
           }

       };

       var data = {"tableId": tableId,"id":idRow};
       xmlhttp.open("POST", url, true);
       xmlhttp.send(JSON.stringify(data));

   }
   function CreateDDDel() {
       var dd = document.createElement("div");
       dd.id="ddmenu";
       dd.className="panel panel-danger";
       var p_header = document.createElement("div");
       p_header.className="panel-heading";
       p_header.innerHTML="Delete";
       var p_body = document.createElement("div");

       var el = document.createElement("p");
       el.innerHTML= columnNames[0] ;

       var text = document.createElement("input");
       text.type="text";
       text.id =columnNames[0];
       el.appendChild(text);
       p_body.appendChild(el);

       var button = document.createElement("input");
       button.type = "button";
       button.value = "Apply";
       button.className="btn btn-xs btn-primary";
       button.onclick =function(){
           DeleteRow(document.getElementById(columnNames[0]).value);

       };
       p_body.appendChild(button);
       dd.appendChild(p_header);
       dd.appendChild(p_body);
       var eldd= document.getElementById(dd.id) ;
       if (eldd === null){
           document.getElementsByTagName("body")[0].appendChild(dd);
       } else {
           var pe= eldd.parentElement;
           pe.removeChild(eldd);
           pe.appendChild(dd);
           //eldd.appendChild(dd);
       }

   }
