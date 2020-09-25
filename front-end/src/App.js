import React, {Component} from 'react';
import {BrowserRouter, Route,Switch } from "react-router-dom";
import './App.css';
import Header from "./components/Header";
import Mall from "./components/Mall";
import Order from "./components/Order";
import AddGoods from "./components/AddGoods";
import Footer from './components/Footer';


class App extends Component {
  render() {
    return (
      <div className="app">
        <BrowserRouter>
        <Header /> 
          <Switch>
            <Route exact path="/" component={Mall} />
            <Route exact path="/my-order" component={Order} />
            <Route exact path="/add-goods" component={AddGoods} />
          </Switch>
        </BrowserRouter>
        <Footer />
      </div>
    );
  }
}

export default App;
