import React from 'react';
import './navBar.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';


const NavBar = () => (
  <div >
    <Navbar>
      <Container>
        <Navbar.Brand href="/home">Home</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/registration">Registration</Nav.Link>
            <Nav.Link href="/myLogin">Login</Nav.Link>
          </Nav>
      </Container>
    </Navbar>
  </div>
);

export default NavBar;
