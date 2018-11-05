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

function UpdateTable (id,content) {
//Send data to server to update table
    var xmlhttp = new XMLHttpRequest();
    var url = "update";

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
           alert("ok");
        }

    };
    
    var data = {"tableId": id,"content":content};
    xmlhttp.open("POST", url, true);
    xmlhttp.send(JSON.stringify(data));
}
function CreateDropdown() {
    UpdateTable(3,{"idEmployee":39,"NumberOfSales":38,"AmountOfSales": 8745});
}