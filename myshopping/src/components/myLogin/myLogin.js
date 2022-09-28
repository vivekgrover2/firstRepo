import React, { useState } from 'react';
import PropTypes from 'prop-types';
import render   from  "react-dom"
import './myLogin.css';
import API from '../../utils/api.js'
// use the component in your app!

function MyLogin (props){ 
  React.useEffect(() => { API.get("http://localhost:8080/myshopping/user")
  .then(response => console.log(response.name))
  }, []); // <-- Have to pass in [] here!
 
  const[userName, setUserName] = useState('');
  const[password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    addPosts();
 }; 

  const addPosts = async() =>{
    let item = {userName, password};
      let res = await fetch("http://localhost:8080/myshopping/createUser", 
      {
        method : 'POST',
      headers: {
        'Content-Type': 'application/json',
       'Accept': 'application/json',
      'Access-Control-Allow-Origin': '*'
     },
     body : JSON.stringify(item)
    });
   res = await  res.json();
    console.log(res);
}
return (
<>
<div>
<form onSubmit={handleSubmit}>
  <div>
    <h3>User Login Page </h3>
  </div>
      <label>
       <b> UserName :</b> <input type="text" value={userName} onChange = {(e) => setUserName(e.target.value)}>
    </input>
      </label> 
      <br></br>
      <br></br>
      <label>
        <b> Password :</b> <input type="text" value={password} onChange = {(e) => setPassword(e.target.value)}></input>
      </label> 
      <br></br>
      <br></br>
      <button type="Submit">Submit </button>
</form>
</div>
</>
)
};


export default MyLogin;
