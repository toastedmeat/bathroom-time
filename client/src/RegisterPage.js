import * as React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class RegisterPage extends React.Component{

  constructor(props) {
    super(props);

    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);

    this.state = {
      username: '',
      password: '',
      firstName: '',
      lastName: '',
      email: ''
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

  handleFirstNameChange(e) {
    this.setState({ firstName: e.target.value });
  }

  handleLastNameChange(e) {
    this.setState({ lastName: e.target.value });
  }

  handleEmailChange(e) {
    this.setState({ email: e.target.value });
  }

  onRegisterClick() {
    fetch('http://localhost:8080/user/register', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: this.state.username,
        password: this.state.password,
        firstName: this.state.firstName,
        lastName: this.state.lastName,
        email: this.state.email
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
            <Label for="username" className="mr-sm-2">username</Label>
            <Input value={this.state.username} onChange={(e) => this.handleUsernameChange(e)} type="username" name="username" id="username" placeholder="username" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="password" className="mr-sm-2">password</Label>
            <Input value={this.state.password} onChange={(e) => this.handlePasswordChange(e)} type="password" name="password" id="password" placeholder="password" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="firstName" className="mr-sm-2">firstName</Label>
            <Input value={this.state.firstName} onChange={(e) => this.handleFirstNameChange(e)} type="firstName" name="firstName" id="firstName" placeholder="firstName" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="lastName" className="mr-sm-2">lastName</Label>
            <Input value={this.state.lastName} onChange={(e) => this.handleLastNameChange(e)} type="lastName" name="lastName" id="lastName" placeholder="lastName" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="email" className="mr-sm-2">email</Label>
            <Input value={this.state.email} onChange={(e) => this.handleEmailChange(e)} type="email" name="email" id="email" placeholder="email" />
          </FormGroup>
          <div className="mt-5"></div>
          <Button className="mr-1 float-right" onClick={() => {this.onRegisterClick(); this.props.toggleRegister()}}>Register</Button>
        </Form>
      </div>
    );
  }
}

export default RegisterPage;
