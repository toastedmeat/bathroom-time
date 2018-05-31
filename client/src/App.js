import React, { Component } from 'react';
import logo from './logo.svg';
import './css/App.css';
import BathroomList from './BathroomList';
import LoginPage from './LoginPage';
import {Button, Modal, ModalBody, ModalHeader} from 'reactstrap';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      modal: false
    };

    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({
      modal: !this.state.modal
    });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <div className="float-right">
            <Button color="danger" onClick={this.toggle}>Login</Button>
            <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}>
              <ModalHeader toggle={this.toggle}>Login</ModalHeader>
              <ModalBody>
                <LoginPage toggleModal={() => this.toggle()}/>
              </ModalBody>
            </Modal>
          </div>
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <BathroomList />
      </div>
    );
  }
}

export default App;
