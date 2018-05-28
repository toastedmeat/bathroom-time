import * as React from 'react';
import GiphyImage from './GiphyImage';


class BathroomList extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      bathrooms: [],
      isLoading: false
    };
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8080/bathroom/good')
      .then(response => response.json())
      .then(data => this.setState({bathrooms: data, isLoading: false}));
  }

  render() {
    const {bathrooms, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
        <h2>Bathroom List</h2>
        {bathrooms.map((bathroom) =>
          <div key={bathroom.id}>
            {bathroom.name}<br/>
            <GiphyImage name={bathroom.name}/>
          </div>
        )}
      </div>
    );
  }
}

export default BathroomList;
