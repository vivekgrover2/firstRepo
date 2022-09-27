import React, { useState } from 'react';
import PropTypes from 'prop-types';
import render   from  "react-dom"
import './myLogin.css';
import API from '../../utils/api.js'
// use the component in your app!

function MyLogin (props){ 
  React.useEffect(() => { API.get("http://localhost:8080/users/user")
  .then(response => console.log(response.name))
  }, []); // <-- Have to pass in [] here!
 
  const[userName, setUserName] = useState('');
  const[password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    addPosts(userName, password);
 }; 
  const addPosts = async(userName, password) =>{
      let res = await fetch("http://localhost:8080/users/createUser", 
      {
        method : 'POST',
        mode: 'no-cors',
        body : JSON.stringify({
        userName: userName,
        password: password
      }),
      headers: {
        'Content-type': 'application/json',
        'Access-Control-Allow-Origin' : 'http://localhost:8080/users/createUser',
        'Access-Control-Allow-Methods': 'GET,HEAD,OPTIONS,POST,PUT',
        'Access-Control-Allow-Credentials': true,
        'Access-Control-Allow-Headers': 'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers'
     }
    });
   let resJson = await  res.json().then(console.log("hello"));
    console.log(resJson);
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
