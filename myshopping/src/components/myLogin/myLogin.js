import React from 'react';
import PropTypes from 'prop-types';
import render   from  "react-dom"
import './myLogin.css';
import API from '../../utils/api.js'
// use the component in your app!

function MyLogin (props){ 
  React.useEffect(() => { API.get("http://localhost:8080/users")
  .then(response => console.log(response.name))
  }, []); // <-- Have to pass in [] here!
 
return (
<div>
<h1>Login Page</h1>
<h2> h2 </h2>
</div>
)
};


export default MyLogin;
