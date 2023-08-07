<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
<!-- 		<div class="col-sm-7"> -->
			<div class="col-md-3" v-for="vo in product_list">
			      <div class="thumbnail">
			        <a href="#">
			          <img :src="vo.poster" alt="Lights" style="width:250px; height:150px; border-radius:20px;">
			          <div class="caption">
			            <p style="font-size: 9px;">{{vo.title }}&nbsp;<span style="color: orange;">{{vo.priced_sale}}</span></p>
			          </div>
			        </a>
			      </div>
		</div>
<!-- 		</div> -->
		<div class="col-sm-4">
		</div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
		<div class="text-center">
			<input type="button" value="이전" class="btn btn-sm btn-danger" v-on:click="prev()">
			{{curpage}} page / {{totalpage}} pages
			<input type="button" value="다음" class="btn btn-sm btn-primary" v-on:click="next()">
		</div>
	</div>
</div>

<script>
new Vue({
	el:'.container',
	data:{
		curpage:1,
		totalpage:0,
		product_list:[], //이미지
		product_detail:{}
	},
	mounted:function(){
		this.send();
	},
	methods:{
		send:function(){
			axios.get("http://localhost/web/product/list_vue.do",{
				params:{
					page:this.curpage
				}
			}).then(response=>{
				console.log(response.data)
				this.product_list=response.data;
				this.curpage=response.data[0].curpage;
				this.totalpage=response.data[0].totalpage;
			})
		},
		prev:function(){
			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
			this.send();
		},
		next:function(){
			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
			this.send();
		}
	}
})
</script>
</body>
</html>