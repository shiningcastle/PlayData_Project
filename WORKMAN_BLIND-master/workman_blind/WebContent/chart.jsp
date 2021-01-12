<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구직자 대비 취업률</title>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
    google.charts.load('current', { 'packages': ['corechart'] });
    
    let answer = [['년도', '구인인원', '구직자수']]
    let workdata;
    let yearcount = [];
    let wyear;
    let workyear;
    let flag;

    function getyear(value) {
      return String(value.년월).substr(0,4) === workyear;
    }

    function getsum(total, value) {
      return total + value;
    }

    function getemployer(value) {
      return parseFloat(value.구인인원.replace(",",""));
    }

    function getemployee(value) {
      return parseFloat(value.구직자수.replace(",",""));
    }

    



    function chartView() {

    var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            workdata = JSON.parse(this.responseText);

            for (var i = 0; i < workdata.length; i++) {

                wyear = String(workdata[i].년월);
                workyear = wyear.substr(0, 4);

                 flag = true

            for (var j = 0; j < yearcount.length; j++) {
              if (String(workdata[i].년월).substr(0,4) === yearcount[j]) {
                flag = false
              }
            }
            

            
            if(flag) {
                var yearlist = workdata.filter(getyear);
                var empr = yearlist.map(getemployer);
                var empe = yearlist.map(getemployee);
                var rsum = empr.reduce(getsum);
               
                var esum = empe.reduce(getsum);
                var inlist = [];

                inlist.push(workyear);
                inlist.push(rsum);
                inlist.push(esum);

                answer.push(inlist);
                yearcount.push(workyear);
                console.log(answer)
            }
        }
        var data = google.visualization.arrayToDataTable(answer);
        var options = {
            title: '',
            curveType: 'function',
            legend: { position: 'bottom' }
          };
          var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
          chart.draw(data, options);
        }
    }
    xhttp.open("GET", "worknet.json", true);
      xhttp.send();
}
    </script>
</head>

<body>
    <div id="curve_chart" style="width: 900px; height: 500px;"></div>

    
</body>
</html>