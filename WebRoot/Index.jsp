<%@ page language="java" import="test.*,java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<title>index</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
	<script src="js/jquery.min.js"></script>
	<script src="./papaparse.min.js"></script>
	<style type="text/css">
			#videoUrl{opacity:0;position:absolute;margin-left: -50%;margin-top: -27%;width: 217px;}
			a{position: relative;display: inline-block;}
		 
        	html,body{  
                height: 100%;  
                width: 100%;  
        	}  
        	#banner{  
                height: 100%;  
                width: 100%;  
        	}
        	h2{
        		margin-top:1%
        	}
        	form{
        		margin-top: 20%;
        		margin-left:64%;
        		width:420px;
        		height:80px;
        		z-index:2;
        	}
        	#main{

                height: 100%;  
                width: 100%;
                margin-top: -30%;

        	} 
		</style>
		    <!-- 引入 ECharts 文件 -->
	<script src="js/echarts.min.js"></script>
</head>
<body>
	<div id="banner">
				<h2>Ju Mao Shuo De</h2>
				<form  action="servlet/GetJson" enctype="multipart/form-data" method="post"  id="form1" >
				<a href="#" class="button style2 scrolly" id="aa" >上传文件
				<input id="videoUrl" type="file" name="videoUrl" class="button style2 scrolly" >
				<div class="showFileName"></div><!--解决多次重复上传-->
				<div class="fileerrorTip"></div>
				</a>
				<input id="videoUrl2"  type="submit" class="button style2 scrolly" >
				</form>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <!--<div id="main" style="width: 1000px;height:600px;margin-top:-28%;margin-left:2%;z-index:1;"></div>-->
    <div class="htmleaf-container">
        
        <div data-to-value='0' data-items-count='32' id="p1_barPie" class="barPie barPie--radio">
          <span class="barPie__value" id="Progress">0</span>
          <div class="barPie__ring">
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem31" value="100" hidden="hidden"/>
            <label for="p1_barPieItem31" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem30" value="96.875" hidden="hidden"/>
            <label for="p1_barPieItem30" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem29" value="93.75" hidden="hidden"/>
            <label for="p1_barPieItem29" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem28" value="90.625" hidden="hidden"/>
            <label for="p1_barPieItem28" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem27" value="87.5" hidden="hidden"/>
            <label for="p1_barPieItem27" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem26" value="84.375" hidden="hidden"/>
            <label for="p1_barPieItem26" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem25" value="81.25" hidden="hidden"/>
            <label for="p1_barPieItem25" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem24" value="78.125" hidden="hidden"/>
            <label for="p1_barPieItem24" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem23" value="75" hidden="hidden"/>
            <label for="p1_barPieItem23" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem22" value="71.875" hidden="hidden"/>
            <label for="p1_barPieItem22" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem21" value="68.75" hidden="hidden"/>
            <label for="p1_barPieItem21" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem20" value="65.625" hidden="hidden"/>
            <label for="p1_barPieItem20" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem19" value="62.5" hidden="hidden"/>
            <label for="p1_barPieItem19" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem18" value="59.375" hidden="hidden"/>
            <label for="p1_barPieItem18" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem17" value="56.25" hidden="hidden"/>
            <label for="p1_barPieItem17" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem16" value="53.125" hidden="hidden"/>
            <label for="p1_barPieItem16" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem15" value="50" hidden="hidden"/>
            <label for="p1_barPieItem15" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem14" value="46.875" hidden="hidden"/>
            <label for="p1_barPieItem14" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem13" value="43.75" hidden="hidden"/>
            <label for="p1_barPieItem13" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem12" value="40.625" hidden="hidden"/>
            <label for="p1_barPieItem12" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem11" value="37.5" hidden="hidden"/>
            <label for="p1_barPieItem11" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem10" value="34.375" hidden="hidden"/>
            <label for="p1_barPieItem10" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem9" value="31.25" hidden="hidden"/>
            <label for="p1_barPieItem9" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem8" value="28.125" hidden="hidden"/>
            <label for="p1_barPieItem8" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem7" value="25" hidden="hidden"/>
            <label for="p1_barPieItem7" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem6" value="21.875" hidden="hidden"/>
            <label for="p1_barPieItem6" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem5" value="18.75" hidden="hidden"/>
            <label for="p1_barPieItem5" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem4" value="15.625" hidden="hidden"/>
            <label for="p1_barPieItem4" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem3" value="12.5" hidden="hidden"/>
            <label for="p1_barPieItem3" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem2" value="9.375" hidden="hidden"/>
            <label for="p1_barPieItem2" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem1" value="6.25" hidden="hidden"/>
            <label for="p1_barPieItem1" class="barPie__ring__item"></label>
            <input type="radio" name="barPieRadioGroup" id="p1_barPieItem0" value="3.125" hidden="hidden"/>
            <label for="p1_barPieItem0" class="barPie__ring__item"></label>
          </div>
        </div>
        
    </div>
    </div>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
    (function () {
        var form = document.getElementById("form1");
        var progress = document.getElementById("Progress");
        var requestid = null;
        $("#videoUrl2").click(function(event) {
        	alert(progress.nodeName);
        	var filetemp = document.getElementById("videoUrl").files[0].name;
            //阻止默认事件
            alert(filetemp);
            event.preventDefault();
            //循环查看状态 setInterval(code,int)以int毫秒间隔调用code
            var t = setInterval(function(){
            //alert(filetemp);
                $.ajax({
                    url: 'ProcessServlet',
                    type: 'POST',
                    dataType: 'text',
                    data: {
                        filename:filetemp,
                    },
                    success: function (responseText) {
                        var data = JSON.parse(responseText);
                        var p = parseFloat((data.progress / data.size)*100);
                        //前台更新进度
                        progress.innerText = Math.round(p*100)/100;
                        //alert("sucess1");
               
                    },
                    error: function(){
                        alert("error1");
                    }
                });
            }, 600);
            //上传文件
            $.ajax({
                url: 'uploadServlet',
                type: 'POST',
                dataType: 'text',
                data: new FormData(form),
                processData: false,
                contentType: false,
                success: function (data) {
                    //上传完成，清除循环事件
                    clearInterval(t);
                    //将进度更新至100%
                    progress.innerText = 100;
                    console.log("sucess2");
                    requestid = data;
                    alert(requestid); 
                    if(requestid!=null){
                    var a = document.createElement('a');
    				var url = "GetJson?id="+requestid;
   	 				var filename = '测试结果数据.csv';
    				a.href = url;
    				a.download = filename;
    				a.click();
    				}
                          
    	},
                error: function(){
                    alert("error2");
                }
            });
            
           /*	var p = null;
            var s = setInterval(function() {
            	$.ajax({
                    url: 'GetJsonListener',
                    type: 'POST',
                    dataType: 'text',
                    success: function (responseText) {
                    var data = JSON.parse(responseText);
                    p = data.isgetdata;
               		if(p){
                		var a = document.createElement('a');
    					var url = "GetJson";
   	 					var filename = '测试结果数据.csv';
    					a.href = url;
    					a.download = filename;
    					a.click();
    					clearInterval(s);
          			}
                    },
                    error: function(){
                        alert("error1");
                    }
                });
            }, 200);*/
        var flag = false;
       /* var s = setInterval(function() {
        $.ajax({
        	url: 'showMap',
            type: 'POST',
            dataType: 'text',
            data:{
            	requestid:requestid,
            },
            success: function (data) {
            	var jsondata = JSON.parse(data);
            		alert(jsondata.name0);
        			myChart.setOption({
        
            		yAxis: {
		        		type: 'category',
		        		data: [jsondata.name0,jsondata.name1,jsondata.name2,jsondata.name3,jsondata.name4,jsondata.name5,jsondata.name6]
		    		},
        			});
				
            },
            error: function(){
                 alert("show_error1");
            }
        });
        	
        }, 3000);*/
            return false; 
        });
        var myChart = echarts.init(document.getElementById('main'));
		
        // 指定图表的配置项和数据
		 var option = {
    		tooltip : {
        	trigger: 'axis',
        	axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    	},

    	grid: {
        	left: '3%',
        	right: '4%',
        	bottom: '3%',
        	containLabel: true
    },
    	xAxis:  {
        	type: 'value'
    	},
    	yAxis: {
        	type: 'category',
        	data: ['周一','周二','周三','周四','周五','周六','周日'],
    	},
    	series: [
        {
            name: '直接访问',
            type: 'bar',
            stack: '总量',
            barMaxWidth:40,//最大宽度
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [320, 302, 301, 334, 390, 330, 320]
        },
        {
            name: '邮件营销',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: '联盟广告',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
            name: '视频广告',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [150, 212, 201, 154, 190, 330, 410]
        },
        {
            name: '搜索引擎',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [820, 832, 901, 934, 1290, 1330, 1320]
        }
    ]
};

			myChart.setOption(option);
    })();
    </script>
    </body>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.poptrox.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<script type="text/javascript">
		var a = document.getElementById("aa");
		$("a").on("change","input[type='file']",function(){
    		var filePath=$(this).val();
    		if(filePath.indexOf("csv")!=-1){
        		$(".fileerrorTip").html("").hide();
        		var arr=filePath.split('\\');
        		var fileName=arr[arr.length-1];
        		$(".showFileName").html(fileName);
        		a.removeChild(a.firstChild);
        		var submit = document.getElementById("videoUrl2");
        		//submit.style.marginTop:
        		
        		
    		}else{
        		$(".showFileName").html("");
        		$(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
        		return false 
    		}
    
})
		</script>
		</body>
    <script src='js/stopExecutionOnTimeout.js?t=1'></script>
    <script src='js/do-in.js'></script>
    <script type="text/javascript">
    (function (ELEMENT) {
        ELEMENT.matches = ELEMENT.matches || ELEMENT.mozMatchesSelector || ELEMENT.msMatchesSelector || ELEMENT.oMatchesSelector || ELEMENT.webkitMatchesSelector;
        ELEMENT.closest = ELEMENT.closest || function closest(selector) {
            var element = this;
            while (element) {
                if (window.CP.shouldStopExecution(1)) {
                    break;
                }
                if (element.matches(selector))
                    break;
                element = element.parentElement;
            }
            window.CP.exitedLoop(1);
            return element;
        };
    }(Element.prototype));
    var barPie = {
        onChnage: function (e) {
            if (e.target.name != 'barPieRadioGroup')
                return;
            var scopeElm = e.target.closest('.barPie--radio');
            barPie.update(scopeElm, +e.target.value);
            if (!scopeElm.active)
                scopeElm.querySelector('.barPie__ring').lastElementChild.addEventListener('click', barPie.clickToNull);
            scopeElm.active = 1;
        },
        clickToNull: function () {
            var that = this;
            if (this.previousElementSibling.checked)
                setTimeout(function () {
                    that.previousElementSibling.checked = false;
                    that.closest('.barPie--radio').querySelector('.barPie__value').innerHTML = '0';
                }, 0);
        },
        update: function (scopeElm, value, speed, extraStep) {
            if (!scopeElm)
                return;
            var valueElm = scopeElm.querySelector('.barPie__value'), inital = +valueElm.innerHTML, delta = value - inital, doin;
            function step(t, elapsed) {
                t = 1 - Math.exp(-t * 7);
                var value = delta * t + inital, remainder = value % 1;
                if (t > 0.99 && (remainder > 0.9 || remainder < 0.01)) {
                    value = Math.round(value);
                    doin.step = function () {
                    };
                } else
                    value = value.toFixed(remainder ? 1 : 0);
                valueElm.innerHTML = value;
                if (extraStep)
                    extraStep(t);
            }
            if (!valueElm.doin) {
                doin = new Doin(step, speed || 0.33);
                valueElm.doin = doin;
            } else
                doin = valueElm.doin;
            doin.step = step;
            doin.run();
        }
    };
    document.addEventListener('change', barPie.onChnage);
    var barPies = document.querySelectorAll('.barPie');
    setTimeout(lazyCount, 1500);
    function lazyCount() {
        var currentBarPie, toValue, itemsCount;
        function step(t) {
            var itemIdx = Math.round(itemsCount * (toValue / 100) * t);
            document.getElementById(currentBarPie.id + 'Item' + itemIdx).checked = true;
        }
        for (var i = barPies.length; i--;) {
            if (window.CP.shouldStopExecution(2)) {
                break;
            }
            currentBarPie = barPies[i];
            toValue = currentBarPie.dataset.toValue;
            if (toValue) {
                itemsCount = currentBarPie.dataset.itemsCount;
                barPie.update(currentBarPie, toValue, 1.5, step);
            }
        }
        window.CP.exitedLoop(2);
    }
    </script>

</html>