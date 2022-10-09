import './App.css';
import NavBar from './components/navBar/navBar';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Registration from './components/registration/registration';
import MyLogin from './components/myLogin/myLogin';
import Home from './components/home/home';
function App() {
  return (
    <div className="App">
      <NavBar/>

      <Router>
      <Switch>
          <Route exact path="/myLogin">
            <MyLogin />
          </Route>
          <Route exact path="/registration">
            <Registration />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;