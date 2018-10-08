import React, { Component } from 'react';

import './App.css';
import EntitiesList from './EntitiesList.js';
import Nav from './Nav.js';

class App extends Component {
    render() {
        return (<div id="the-one-ring">
                <Nav />
                <div id="app">
                <EntitiesList />
                </div>
               </div>);
    }
}

export default App;
