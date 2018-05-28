import React, { Component } from 'react';
import logo from './logo.svg';
import './css/App.css';
import BathroomList from './BathroomList';
import LoginPage from './LoginPage';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <BathroomList />
        <LoginPage />
      </div>
    );
  }
}

export default App;
