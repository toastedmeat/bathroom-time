import * as React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class RegisterButton extends React.Component{

  constructor(props) {
    super(props);

    this.state = {
      email: '',
    };
  }

  componentDidMount() {
  }

  onRegisterClick() {
    fetch('http://localhost:8080/user/register', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: this.props.username,
        password: this.props.password,
      })
    }).then(function(results){
      console.log(results);
    });
  }

  render() {
    return (
      <Button className="mr-1 float-right" onClick={() => {this.onRegisterClick(); this.props.toggleModal()}}>Register</Button>
    );
  }
}

export default RegisterButton;
