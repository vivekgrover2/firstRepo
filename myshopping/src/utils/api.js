const API={

    get(url){
    return  fetch(url)
     .then(response =>response.json()) 
}
}
export default API