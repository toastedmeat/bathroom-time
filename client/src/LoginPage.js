import * as React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class LoginPage extends React.Component{

  constructor(props) {
    super(props);

    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);

    this.state = {
      isLoading: false,
      username: '',
      password: ''
    };
  }

  componentDidMount() {
  }

  handleUsernameChange(e) {
    this.setState({ username: e.target.value });
  }

  handlePasswordChange(e) {
    this.setState({ password: e.target.value });
  }

  onSubmitLoginClick() {
    fetch('http://localhost:8080/user/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: this.state.username,
        password: this.state.password,
      })
    }).then(function(results){
      console.log(results);
    });
  }

  render() {
    return (
      <div className="container">
        <Form>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="loginUsername" className="mr-sm-2">Username</Label>
            <Input value={this.state.username} onChange={(e) => this.handleUsernameChange(e)} type="username" name="username" id="loginUsername" placeholder="Username" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="loginPassword" className="mr-sm-2">Password</Label>
            <Input value={this.state.password} onChange={(e) => this.handlePasswordChange(e)} type="password" name="password" id="loginPassword" placeholder="Password" />
          </FormGroup>
          <div className="mt-5"></div>
          <Button className="float-right btn-danger" onClick={() => {this.onSubmitLoginClick(); this.props.toggleLogin()}}>Submit</Button>
          <Button className="float-right mr-1 btn-info" onClick={() => {this.props.toggleLogin(); this.props.toggleRegister()}}>Register</Button>
        </Form>
      </div>
    );
  }
}

export default LoginPage;
