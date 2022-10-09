import React, { useState } from 'react';
import './registration.css';
import API from '../../utils/api.js'

 function Registration(props) {
  
  React.useEffect(() => { API.get("http://localhost:8080/registerUser/getRegisteredUser")
  .then(response => console.log(response.name))
  }, []); // <-- Have to pass in [] here!
 

  const[fullName, setFullName] = useState('');
  const[email, setEmail] = useState('');
  const[password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
     registerUser();
 }; 

  const registerUser = async() =>{
     let item = {fullName, email, password};
      let res = await fetch("http://localhost:8080/registerUser/create", 
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
    <h3>Register here... </h3>
  </div>
      <label>
       <b> FullName :</b> <input type="text" value={fullName} onChange = {(e) => setFullName(e.target.value)}></input>
      </label> 
      <br></br>
      <br></br>
      <label>
       <b> Email :</b> <input type="text" value={email} onChange = {(e) => setEmail(e.target.value)}></input>
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

export default Registration;
