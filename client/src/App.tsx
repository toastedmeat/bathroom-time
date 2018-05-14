import * as React from 'react';
import './App.css';
import BathroomList from './BathroomList';

import logo from './logo.svg';

class App extends React.Component<{}, any> {
  public render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <BathroomList />
      </div>
    );
  }


}

export default App;
