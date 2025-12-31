const {defineStore} = Pinia
const initialState=()=>({
	
	id:'',
	pwd:'',
	name:'',
	isLogin:false	
	
	
})

const useMemberStore = defineStore('member',{
	state:initialState,
	actions:{
		validate(idRef, pwdRef){
			if(!this.id){
				idRef?.focus()
				return false
			}
			if(!this.pwd){
				pwdRef?.focus()
				return false
			}
			return true
		},
		async login(idRef, pwdRef){
			if(!this.validate(idRef,pwdRef)) return
			const {data} = await api.get('/member/login_vue/',{
				params:{
					id:this.id,
					pwd:this.pwd
				}
			})
			switch(data.msg){
				case 'OK':
					this.id=data.id
					this.name=data.name
					this.isLogin =  true
					location.href='/list'
					break
				case 'NOID':
					alert("아이디가 존재하지 않습니다.")
					this.id=''
					this.pwd=''
					idRef?.focus()
					break
				case 'NOPWD':
					alert("비밀번호가 틀렸습니다.")
					this.pwd=''
					pwdRef?.focus()
					break	
			}
		},
		async logout(){
			await api.get('/member/logout')
		}
	}
})