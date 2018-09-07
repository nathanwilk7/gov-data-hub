import React, { Component } from 'react';

class EntitiesList extends Component {
    constructor() {
        super();
        this.state = {
            test: "Loading..."
        };
    }
    render() {
        return (
                <div>
                <h1>{this.state.test}</h1>
                <Button variant="contained" color="primary">
                Hello World
            </Button>
                </div>
        );
    }
    componentDidMount() {
        fetch('http://localhost:8080/entities')
            .then(resp => resp.json())
            .then(data => this.setState({test: data[0].name}));
    }
}

export default EntitiesList;
