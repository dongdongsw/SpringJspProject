const {defineStore} = Pinia
const  useRecipeStore = defineStore('recipe',{
	// state : 공통 사용 변수, props
	state:()=>({
		list:[],
		curpage:1,
		totalpage:0,
		startPage:0,
		endPage:0
	}),
	getters:{
		range:(state)=>{
			const arr = []
			for(let i = state.startPage; i<=state.endPage; i++){
				arr.push(i)
			}
			return arr
		}
	},
	actions:{
		async recipeListData(){
			const res = await api.get('/recipe/list_vue/',{
				params:{
					page:this.curpage
				}
			})
			console.log(res.data)
			this.setPageData(res.data)
		},
		setPageData(data){
			this.list = data.list
			this.curpage = data.curpage
			this.totalpage = data.totalpage
			this.startPage = data.startPage
			this.endPage = data.endPage
		},
		movePage(page){
			this.curpage = page
			this.recipeListData()
		}
	}
})