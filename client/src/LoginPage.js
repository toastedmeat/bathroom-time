import * as React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class LoginPage extends React.Component{

  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);

    this.state = {
      isLoading: false,
      value: ''
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

  handleChange(e) {
    this.setState({ value: e.target.value });
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
            <Label for="exampleEmail" className="mr-sm-2">Email</Label>
            <Input type="email" name="email" id="exampleEmail" placeholder="Email" />
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="examplePassword" className="mr-sm-2">Password</Label>
            <Input type="password" name="password" id="examplePassword" placeholder="Password" />
          </FormGroup>
          <div className="mt-5"></div>
          <Button>Submit</Button>
        </Form>
      </div>
    );
  }
}

export default LoginPage;
