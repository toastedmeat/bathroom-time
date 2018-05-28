import * as React from 'react';
import {Button, Checkbox, Col, ControlLabel, Form, FormControl, FormGroup} from 'react-bootstrap';

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
      <Form horizontal={true}>
        <FormGroup controlId="formHorizontalEmail">
          <Col componentClass={ControlLabel} sm={2}>
            Email
          </Col>
          <Col sm={10}>
            <FormControl type="email" placeholder="Email" />
          </Col>
        </FormGroup>

        <FormGroup controlId="formHorizontalPassword">
          <Col componentClass={ControlLabel} sm={2}>
            Password
          </Col>
          <Col sm={10}>
            <FormControl type="password" placeholder="Password" />
          </Col>
        </FormGroup>

        <FormGroup>
          <Col smOffset={2} sm={10}>
            <Checkbox>Remember me</Checkbox>
          </Col>
        </FormGroup>

        <FormGroup>
          <Col smOffset={2} sm={10}>
            <Button type="submit">Sign in</Button>
          </Col>
        </FormGroup>
      </Form>
    );
  }
}

export default LoginPage;
