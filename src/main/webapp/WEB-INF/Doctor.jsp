<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/30
  Time: 下午6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<!-- lang属性表示当前文档显示的语言，在很多国际化的网站中会遇到，zh-CN定义语言为中文，en定义语言为英语 -->
<!-- html lang="zh-CN"解决Mac版Firefox中文字体显示问题，Bootstrap也建议加上 -->
<head>
    <script src="https://cdn.staticfile.org/angular.js/1.6.3/angular.min.js"></script>
    <title>Doctor Dashboard</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo-icon.jpg" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min2.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-switch.css" rel="stylesheet">
    <style>
        *{
            font-family:"微软雅黑","黑体","宋体";
        }
        .space_lg{
            height:50px;
            clear: both;
            text-align:right;
        }
        .space_md{
            height:30px;
            clear: both;
        }
        .space_sm{
            height:10px;
            clear: both;

        }
        .space_demo{
            border-bottom:1px solid black;
        }

        @media (min-width: 768px) {
            .container {
                width: 750px;
            }
            #scrollDiv{
                left:0px;
            }
        }
        @media (min-width: 992px) {
            .container {
                width: 990px;
            }
            #scrollDiv{
                left:0px;
            }
        }
        @media (min-width: 1200px) {
            .container {
                width: 1200px;
            }
        }
        @media (min-width: 1400px) {
            .container {
                width: 1350px;
            }
        }
        @media (min-width: 1800px) {
            .container {
                width: 1750px;
            }
            #scrollDiv{
                left:180px;
            }
        }

        .lnk-tools {
            position:fixed;
            bottom:180px;
            right: 80px;
            _position:absolute;
            z-index:999;
            _top:expression(documentElement.scrollTop);
        }
        .lnk-tools button{width: 100px;}
        table tr:nth-child(4n+1){
            background:lightgray;
        }

        table tr:nth-child(4n+2){
            background:lightgreen;
        }
        table tr:nth-child(4n+3){
            background:lightyellow;
        }

        table tr:nth-child(4n){
            background:lightpink;
        }

    </style>
</head>

<body data-target="#scrollDiv" data-offset="0" data-spy="scroll">



<!-- 导航栏 -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0);"><span class="glyphicon glyphicon-home"></span> Doctor Dashboard</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li style="background-color:#555;"><a href="javascript:void(0);"><span class="glyphicon glyphicon-user"></span> &nbsp;&nbsp;Zixiao Xu&nbsp;&nbsp;</a></li>
            <li class="dropdown" style="background-color:#2c7659;">
                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-screenshot"></span> System<span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="javascript:void(0);">Search Patient</a></li>

                    <li class="divider"></li>
                    <li><a href="javascript:void(0);">Login out</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>


<div class="container" style="margin-top:80px;">


    <div class="row">
        <div class="col-md-8">
            <div class="jumbotron" style="height:120px;padding:10px;">
                <div class="row">
                    <div class="col-md-2">
                        <img src="images/people.jpg" style="height:100px;" class="img-thumbnail">
                    </div>
                    <div class="col-md-7">
                        <h3 class="text-info">Zixiao Xu&nbsp;<span class="label label-warning">Chairman</span></h3>
                        <span class="text-info"><strong>Department：</strong></span><span class="text-primary">Emergency</span>&nbsp;<strong>|</strong>&nbsp;


                    </div>
                    <div class="col-md-3">
                        <p style='margin-top:30px;'><a class="btn btn-primary" role="button" href="javascript:openLogin();">Add New Remainder</a></p>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <div class="row">
        <div class="col-md-12">
            <ul id="myTab1" class="nav nav-tabs bg-info">
                <li class="active"><a href="#myLi1" data-toggle="tab">Remainder List</a></li>
                <!--<li><a href="#myLi2" data-toggle="tab"></a></li>-->
                <!--<li><a href="#myLi3" data-toggle="tab"></a></li>-->
            </ul>



            <div id="myTabContent" class="tab-content">

                <!-- 第一块操作区 -->
                <div class="tab-pane fade in active" id="myLi1">
                    <div id="myLi11">
                        <div class="space_sm"></div>
                        <div class="row">
                            <div class="col-md-8">

                                <div class="space_sm"></div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul id="myTab4" class="nav nav-tabs">
                                            <li class="active"><a href="#reco1" data-toggle="tab">Current Remainder</a></li>
                                            <li><a href="#reco2" data-toggle="tab">History Remainder</a></li>

                                            <!--<li><a href="#reco3" data-toggle="tab"></a></li>-->
                                        </ul>

                                        <div  id="myTabContent" class="tab-content">

                                            <div class="tab-pane fade in active" id="reco1">
                                                <div class="space_md"></div>


                                                    <table  ng-app="myApp" ng-controller="myCtrl" class="table">
                                                        <caption>Current Remainder List</caption>
                                                        <thead>
                                                        <tr style="background: white">
                                                            <th>Patient Name</th>
                                                            <th>High Priority Reminder</th>
                                                            <th>Middle Priority Reminder</th>
                                                            <th>Low Priority Reminder</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr  ng-repeat="x in list">
                                                            <td><a target="view_window" href="${pageContext.request.contextPath}/Doctor/${Did}/{{x.pname}}">{{ x.pname }}</a></td>
                                                            <td >{{ x.pname }}</td></a>
                                                            <td>{{ x.high }}</td>
                                                            <td>{{ x.middle }}</td>
                                                            <td>{{ x.low }}</td>
                                                        </tr>
                                                        </tbody>

                                                        <!--  <tbody>

                                                               <tr class="active">
                                                                   <td id="Pname0">James Harden</td>
                                                                   <td id="Rhigh0">3</td>
                                                                   <td id="Rmiddle0">4</td>
                                                                   <td id="Rlow0">4</td>


                                                               </tr>
                                                               <tr class="success">
                                                                   <td id="Pname1">James Harden</td>
                                                                   <td id="Rhigh1">3</td>
                                                                   <td id="Rmiddle1">4</td>
                                                                   <td id="Rlow1">4</td>


                                                               </tr>
                                                               <tr class="warning">
                                                                   <td id="Pname2">James Harden</td>
                                                                   <td id="Rhigh2">3</td>
                                                                   <td id="Rmiddle2">4</td>
                                                                   <td id="Rlow2">4</td>


                                                               </tr>
                                                               <tr class="danger">
                                                                   <td id="Pname3">James Harden</td>
                                                                   <td id="Rhigh3">3</td>
                                                                   <td id="Rmiddle3">4</td>
                                                                   <td id="Rlow3">4</td>


                                                               </tr>
                                                           </tbody>-->

                                                    </table>
                                                </div>
                                            <div class="tab-pane fade" id="reco2">
                                                <div class="tab-pane fade in active" id="reco1">
                                                    <div class="space_md"></div>
                                                    <table class="table">
                                                        <caption>History Remainder List</caption>
                                                        <thead>
                                                        <tr>
                                                            <th>Patient Name</th>
                                                            <th>High Priority Reminder</th>
                                                            <th>Middle Priority Reminder</th>
                                                            <th>Low Priority Reminder</th>


                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="active">
                                                            <td>James Harden</td>
                                                            <td>3</td>
                                                            <td>4</td>
                                                            <td>4</td>


                                                        </tr>
                                                        <tr class="success">
                                                            <td>James Harden</td>
                                                            <td>3</td>
                                                            <td>4</td>
                                                            <td>4</td>

                                                        </tr>
                                                        <tr class="warning">
                                                            <td>James Harden</td>
                                                            <td>3</td>
                                                            <td>4</td>
                                                            <td>4</td>

                                                        </tr>
                                                        <tr class="danger">
                                                            <td>James Harden</td>
                                                            <td>3</td>
                                                            <td>4</td>
                                                            <td>4</td>

                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="tab-pane fade" id="reco2">

                                                </div>

                                            </div>
                                        </div>

                                    </div>


                                </div><!-- /.col-记录 -->
                            </div>
                        </div>


                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
</div>



<div id=win style="display:none; POSITION:absolute; left:50%; top:50%; width:600px;
height:400px; margin-left:-300px; margin-top:-200px; border:1px solid #888; background-color:#decfcf;filter:alpha(opacity:30); opacity:0.5
text-align:center">
    <form action="" method="post">
        <div class="input-group">
            <span class="input-group-addon">Patient ID</span>
            <input type="text" class="form-control" placeholder="Enter Patient ID">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">Description</span>
            <input type="text" class="form-control" placeholder="Enter Description">

        </div>
        <br>
        <a class="btn btn-primary" role="button" style="text-align-center" href="" type="">Save</a>
        <a class="btn btn-primary" role="button" style="text-align-center" href="javascript:closeLogin();">Close</a>
    </form>

</div>

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/switch-need1.js"></script>
<script type="text/javascript" src="js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="js/switch-need2.js"></script>
<!--弹出输入remainder框-->
<script>
    function openLogin() {
        document.getElementById("win").style.display = "";
    }
    function closeLogin() {
        document.getElementById("win").style.display = "none";
    }
</script>

<script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $http) {
        $http({method:'get',
            url:"${pageContext.request.contextPath}"+"/Doctor/"+${Did}
            /*   params:{
                   'Did' : 1
               }*/
        }).then(function (response) {
            $scope.list = response.data;
        });
    })
</script>

<!-- 表单提交前的验证-->



<!--JSON存储表格数据-->
<script>
    /*
              var JSONObject =

                  [   { "did": 1, "high": 10, "low": 1, "middle": 1, "pid": 1, "pname": "Patient1" },
                      { "did": 1, "high": 9, "low": 1, "middle": 4, "pid": 3, "pname": "Patient3" },
                      { "did": 1, "high": 9, "low": 3, "middle": 2, "pid": 4, "pname": "Patient4" },
                      { "did": 1, "high": 9, "low": 2, "middle": 2, "pid": 2, "pname": "Patient2" }]
              for (i = 0; i < JSONObject.length; i++) {
                  document.getElementById("Pname" + i).innerHTML = JSONObject[i].pname
                  document.getElementById("Rhigh" + i).innerHTML = JSONObject[i].high
                  document.getElementById("Rmiddle" + i).innerHTML = JSONObject[i].middle
                  document.getElementById("Rlow" + i).innerHTML = JSONObject[i].low
              }*/
</script>






<script>

    $(function () {
        $('#modalTest').modal({
            backdrop: true,//true:有遮罩背景&点击可关闭modal;false:没遮罩&不可点击关闭;'static':有遮罩不可点击关闭（默认是true）
            keyboard: true,//键盘上的esc键被按下时关闭模态框（默认是true）
            show: false,//模态框初始化之后就立即显示出来（默认是true）
        });
        $('#switch-offColor').on('switchChange.bootstrapSwitch', function (event, state) {
            if (state) {
                $("#myLi22").show();
                $("#myLi21").hide();
            } else {
                $("#myLi21").show();
                $("#myLi22").hide();
            }
            console.log(this); // DOM element
            console.log(event); // jQuery event
            console.log(state); // true | false
        });

        $('#switch-offColor2').on('switchChange.bootstrapSwitch', function (event, state) {
            if (state) {
                $("#myLi32").show();
                $("#myLi31").hide();
            } else {
                $("#myLi31").show();
                $("#myLi32").hide();
            }
            console.log(this); // DOM element
            console.log(event); // jQuery event
            console.log(state); // true | false
        });
    })
</script>
</body>
</html>
