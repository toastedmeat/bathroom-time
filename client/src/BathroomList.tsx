import * as React from 'react';
import GiphyImage from './GiphyImage';

interface IBathroom {
  id: string;
  name: string;
}

// tslint:disable-next-line:no-empty-interface
interface IBathroomListProps {
}

interface IBathroomListState {
  bathrooms: IBathroom[];
  isLoading: boolean;
}

class BathroomList extends React.Component<IBathroomListProps, IBathroomListState> {

  constructor(props: IBathroomListProps) {
    super(props);

    this.state = {
      bathrooms: [],
      isLoading: false
    };
  }

  public componentDidMount() {
    this.setState({isLoading: true});

    fetch('http://localhost:8080/good-bathrooms')
      .then(response => response.json())
      .then(data => this.setState({bathrooms: data, isLoading: false}));
  }

  public render() {
    const {bathrooms, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
        <h2>Bathroom List</h2>
        {bathrooms.map((bathroom: IBathroom) =>
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
