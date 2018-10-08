import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';

import EntitiesList from './EntitiesList.js';

class Nav extends Component {
    render() {
        return (
                <AppBar position="static">
                <Toolbar>
                <Typography variant="display1" color="inherit">
                GovDataHub
            </Typography>
                &nbsp;
                &nbsp;
                &nbsp;
                <Typography variant="headline" color="inherit">
                <a href="#entities" onClick={this.showEntityList()}>
                Entities
            </a>
            </Typography>
                </Toolbar>
                </AppBar>
        );
    }
    showEntityList() {
        return (e) => {
            e.preventDefault();
            ReactDOM.render(<EntitiesList />, document.getElementById("app"));
        };
    }
}

export default Nav;
