<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form action="${pageContext.request.contextPath}/complex/array" method="post">
		爱好: 
		<input type="checkbox" name="hobby" value="踢球">踢球
		<input type="checkbox" name="hobby" value="听音乐">听音乐
		<input type="checkbox" name="hobby" value="看书">看书
		<br>
		<input type="submit" value="测试数组传值" >
	</form>
	<hr>
	<h2>测试List传参</h2>
	<form action="${pageContext.request.contextPath}/complex/list" method="post">
		爱好: 
		<input type="checkbox" name="hobbyList" value="踢球">踢球
		<input type="checkbox" name="hobbyList" value="听音乐">听音乐
		<input type="checkbox" name="hobbyList" value="看书">看书
		<br>
		<input type="submit" value="测试List传值" >
	</form>
	
	<hr>
	<button id="testMap" type="button" >测试Map传参</button>
	
	<hr>
	<button type="button" onclick="jsonToMap()">测试json转map传参</button>
	
	<hr>
	<button type="button" onclick="jsonToList()">测试json转List传参</button>
	
	<hr>
	<button type="button" onclick="jsonToBean()">测试json转Bean传参</button>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		const path = "${pageContext.request.contextPath}"
		
		$(function(){
			//alert(path)
			$('#testMap').click(() => {
				$.ajax({
					url: path + '/complex/map',
					type: 'post',
					dataType: 'text',
					data: "stuMap['id']=1&stuMap['name']=李四",
					success: function(data){
						alert(data);
					}
				});
			});
		})
		
		function jsonToMap() {
			//js对象
			let obj = {id:1,name:"李四"}
			$.ajax({
				url: path + '/json/jsonToMap',
				type: 'post',
				//将js对象转成json字符串
				data: JSON.stringify(obj),
				dataType: 'json',
				contentType: 'application/json;charset=utf-8',
				success: function(data){
					alert(data.msg);
				}
			});
			
		}
		
		function jsonToList() {
	
			let array = [{id:2,name:"张三",age:33}];
			let user = {id:1,name:"李四",age:22};
			array.push(user)
			
			$.ajax({
				url: path + '/json/jsonToList',
				type: 'post',
				data: JSON.stringify(array),
				dataType: 'json',
				contentType: 'application/json;charset=utf-8',
				success: function(data) {
					alert(data.code+" - "+data.msg);
				}
			});
			
		}
		
		function jsonToBean(){
			let obj = {id:1,
					name:"etoak",
					age:22,
					hobbyList:['睡觉','打豆豆'],
					stuMap:{id:2,xxx:20}
			}
			
			$.ajax({
				url: path + "/json/jsonToBean",
				type: 'post',
				data: JSON.stringify(obj),
				dataType: 'json',
				contentType: 'application/json;charset=utf-8',
				success:function(data){
					alert(data.code+" : "+data.msg);
				}
			});
		}
	</script>
</body>
</html>


