

const initialState=()=>({
	reply_list:[],
	cno:0,
	type:2,
	msg:'',
	upReplyNo:null,
	sessionId:'',
	updateMsg:{}
})

const useReplyStore = defineStore('reply',{
	// state
	state:initialState,
	
	// getters
	
	// actions
	actions:{
		toggleUpdate(no,msg){
			this.upReplyNo = this.upReplyNo=== no?null:no
			this.updateMsg[no] = ''
			
		},
		
		// 댓글 목록 읽기
		async replyListData(cno){
			this.cno = cno
			const {data} = await api.get('/reply/list_vue/',{
				params:{
					cno:this.cno,
					type:this.type
				}
			})
			this.reply_list = data.list
			this.cno = data.cno
			this.type = data.type
		},
		// 댓글 수정하기
		async replyUpdate(no){
			
			const {data} = await api.put('/reply/update_vue/',{
				no:no,
				cno:this.cno,
				type:this.type,
				msg:this.updateMsg[no]
			})
			this.reply_list = data.list
			this.cno = data.cno
			this.type = data.type
			this.upReplyNo = null
		},
		// 댓글 추가
		async replyInsert(){
			if(!this.msg.trim()) return
			
			const {data} = await api.post('/reply/insert_vue/',{
				cno:this.cno,
				type:this.type,
				msg:this.msg
			})
			this.reply_list = data.list
			this.cno = data.cno
			this.type = data.type
			this.msg = ''
		},
		// 댓글 삭제
		async replyDelete(no){
			const {data} = await api.delete('/reply/delete_vue/',{
				params:{
					no:no,
					cno:this.cno,
					type:this.type
				}
			})
			this.reply_list = data.list
			this.cno = data.cno
			this.type = data.type
			
		}
		// toggle		
	}
})