import React, { Component } from 'react';
import logo from './logo.svg';
import './css/App.css';
import BathroomList from './BathroomList';
import LoginPage from './LoginPage';
import RegisterPage from './RegisterPage';
import {Button, Modal, ModalBody, ModalHeader} from 'reactstrap';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loginModal: false,
      registerModal: false
    };

    this.toggleLogin = this.toggleLogin.bind(this);
  }

  toggleLogin() {
    this.setState({
      loginModal: !this.state.loginModal
    });
  }

  toggleRegister() {
    this.setState({
      registerModal: !this.state.registerModal
    });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <div className="float-right">
            <Button color="danger" onClick={this.toggleLogin}>Login</Button>
            <Modal isOpen={this.state.loginModal || this.state.registerModal} toggle={this.toggleLogin || this.toggleRegister} className={this.props.className}>
              <ModalHeader toggle={this.toggleLogin}>
                {this.state.loginModal ? 'Login' : null}
                {this.state.registerModal ? 'Register' : null}
              </ModalHeader>
              <ModalBody>
                {this.state.loginModal ? <LoginPage toggleLogin={() => this.toggleLogin()} toggleRegister={() => this.toggleRegister()}/> : null}
                {this.state.registerModal ? <RegisterPage toggleRegister={() => this.toggleRegister()}/> : null}
              </ModalBody>
            </Modal>
          </div>
          <img src="toilet-paper.png" className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to Bathroom Time</h1>
        </header>
        <BathroomList />
      </div>
    );
  }
}

export default App;
