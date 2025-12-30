const api = axios.create({
	baseURL: 'http://localhost:8080',
	timeout: 5000
})

// api.get('/recipe/list')