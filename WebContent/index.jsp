<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List"%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>分析平台</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="core.css" />
	<link href="styles.css" rel="stylesheet">

</head>

<body>

	<h3 align="center">展示平台</h3>


	<div class="admin">

		<div class="content-page">
			<!-- Start content -->
			<div class="content">

				<div class="am-g">
					<ul class="nav nav-tabs">

						<ul class="nav nav-pills">
							<li class="active"><a href="#pilltab1" data-toggle="tab">当前</a></li>

						</ul>

						<div class="tab-content">
							<div class="tab-pane fade in active" id="pilltab1">
								<div class="row">
									<div class="col-xs-12 col-md-6 col-lg-3">
										<div class="panel panel-red panel-widget">
											<div class="row no-padding">
												<div class="col-sm-3 col-lg-5 widget-left">
													<em class="glyphicon glyphicon-user glyphicon-l"></em>
												</div>
												<div class="col-sm-9 col-lg-7 widget-right">
													<div class="large"><%=request.getAttribute("guestNum") %></div>
													<div class="text-muted">客流量</div>
												</div>
											</div>
										</div>
									</div>

									
									<div class="col-xs-12 col-md-6 col-lg-3">
										<div class="panel panel-blue panel-widget ">
											<div class="row no-padding">
												<div class="col-sm-3 col-lg-5 widget-left">
													<em class="glyphicon glyphicon-user glyphicon-l"></em>
												</div>
												<div class="col-sm-9 col-lg-7 widget-right">
													<div class="large"><%=request.getAttribute("entryNum") %></div>
													<div class="text-muted">入店量</div>
												</div>
											</div>
										</div>
									</div>
									


								</div>
							</div>



						</div>
					</ul>
				</div>


				<div class="am-g">
					<ul class="nav nav-tabs">

						<ul class="nav nav-pills">
							<li class="active"><a href="#pilltab1" data-toggle="tab">流量变化</a></li>

						</ul>

						<div class="tab-content">
							<div class="tab-pane fade in active" id="pilltab1">
								<!-- 一周数据折线图 -->
								<div class="card-box">
									<div id="week" style="width: 100%;height: 300px;"></div>
								</div>
							</div>

						</div>

					</ul>
				</div>

			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
	</div>
	</div>

	<!-- navbar -->
	<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

	<script type="text/javascript" src="echarts.min.js"></script>
	<script type="text/javascript">
	
	//从request中获取数据
	<%-- var listGuest_t = new Array();
	listGuest_t = <%=request.getAttribute("listGuest_t")%>;
	//listGuest_t = listGuest_t.replace('[','').replace(']','').split(',');
	var listGuest_n = new Array();
	listGuest_n = <%=request.getAttribute("listGuest_n")%>;
	//listGuest_n = <%=request.getAttribute("listGuest_n")%>.replace('[','').replace(']','').split(',');
	var listEntry_t = new Array();
	listEntry_t = <%=request.getAttribute("listEntry_t")%>;
	//listEntry_t = <%=request.getAttribute("listEntry_t")%>.replace('[','').replace(']','').split(',');
	var listEntry_n = new Array();
	listEntry_n = <%=request.getAttribute("listEntry_n")%>;
	//listEntry_n = <%=request.getAttribute("listEntry_n")%>.replace('[','').replace(']','').split(',');
	 --%>
	
	/*----------------------客流分析-整体概述-----------------------*/
	//折线图-近10次
	(function () {

	    var myChart = echarts.init(document.getElementById("week"));

	    option = {
	        title: {
	            text: '流量变化趋势'
	        },
	        tooltip: {
	            trigger: 'axis'
	        },
	        legend: {
	            data: ['客流量', '入店量']
	        },
	        grid: {
	            left: '3%',
	            right: '4%',
	            bottom: '3%',
	            containLabel: true
	        },
	        toolbox: {
	            feature: {
	                
	            }
	        },
	        xAxis: {
	            type: 'category',
	            boundaryGap: false,
	            data: <%=request.getAttribute("listGuest_t")%>
	        },
	        yAxis: {
	            type: 'value'
	        },
	        series: [
	            {
	                name: '客流量',
	                type: 'line',

	                data: <%=request.getAttribute("listGuest_n")%>
	            },
	            {
	                name: '入店量',
	                type: 'line',

	                data: <%=request.getAttribute("listEntry_n")%>
	            }
	        ]
	    };
	    
	    
	    myChart.setOption(option);
	})();


	</script>

</body>

</html>