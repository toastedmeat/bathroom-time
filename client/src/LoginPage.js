import * as React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class LoginPage extends React.Component{

  constructor(props) {
    super(props);

    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);

    this.state = {
      isLoading: false,
      value: '',
      username: '',
      password: ''
    };
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8080/api/profile/users')
      .then(response => response.json())
      .then(data => this.setState({isLoading: false}));
  }

  getValidationState() {
    const length = this.state.value.length;
    if (length > 10) { return 'success'; }
    else if (length > 5) { return 'warning'; }
    else if (length > 0) { return 'error'; }
    return null;
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
    })
  }

  render() {
    const isLoading = this.state.isLoading;

    if (isLoading) {
      return <p>Loading...</p>;
    }

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
          <Button onClick={() => this.onSubmitLoginClick()}>Submit</Button>
        </Form>
      </div>
    );
  }
}

export default LoginPage;
