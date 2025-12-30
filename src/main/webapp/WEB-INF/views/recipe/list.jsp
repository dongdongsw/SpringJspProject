<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
	<script src="https://unpkg.com/vue-demi"></script>
	<script src="https://unpkg.com/pinia@2/dist/pinia.iife.prod.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<style type="text/css">
		.container{
			margin-top: 50px;
		}
		.row{
			margin: 0px auto;
			width: 960px;
		}
		p{
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
		}
		.nav-link{
			cursor: pointer;
			
		}
		
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
		  <div class="col-md-3" v-for="(vo,index) in store.list" :key="index">
		    <div class="thumbnail">
		      <a :href="'/detail?no=' + vo.no">
		        <img :src="vo.poster" ;title="vo.title" alt="Lights" style="width:240px; height:150px;">
		        <div class="caption">
		          <p>{{vo.chef}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</div>
		<div class="row text-center" style="margin-top:10px;">
			<ul class="pagination">
				<li v-if="store.startPage > 1"><a class="nav-link" @click="store.movePage(store.startPage-1)">&laquo;</a></li>
				<li v-for="i in store.range" :class="i===store.curpage?'active':''"><a class="nav-link" @click="store.movePage(i)">{{i}}</a></li>
				<li v-if="store.endPage < store.totalpage"  @click="store.movePage(store.endPage+1)"><a class="nav-link">&raquo;</a></li>
			</ul>
		</div>
	</div>
	<script src="/js/axios.js"></script>
	<script src="/js/recipeStore.js"></script>
	<script>
		const {createApp, onMounted} = Vue
		const {createPinia} = Pinia
		
		const recipeApp = createApp({
			setup(){
				const store = useRecipeStore()
				onMounted(()=>{
					store.recipeListData()
				})
				
				return {
					store
				}
			}
		})
		
		recipeApp.use(createPinia())
		recipeApp.mount(".container")
	</script>
</body>
</html>