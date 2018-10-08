import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Typography from '@material-ui/core/Typography';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

import Entity from './Entity.js';

class EntitiesList extends Component {
    constructor() {
        super();
        this.state = {
            entities: []
        };
    }
    render() {
        const entities = this.state.entities.map(e => <TableRow key={e.id}><TableCell><a href="test" onClick={this.showEntity(e)}>{e.name}</a></TableCell><TableCell>{e.type}</TableCell><TableCell>{e.description}</TableCell></TableRow>);
        return (<div>
                <Typography variant="title" color="inherit" align="center"><p>Entities</p></Typography>
                <Table>
                <TableHead>
                <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Type</TableCell>
                <TableCell>Description</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {entities}
                </TableBody>
                </Table>
                </div>
        );
    }
    componentDidMount() {
        fetch('http://localhost:8080/entities')
            .then(resp => resp.json())
            .then(data => {this.setState({entities: data});});
    }
    showEntity (entity) {
        return (e) => {
            e.preventDefault();
            ReactDOM.render(<Entity entity={entity} />, document.getElementById("app"));
        };
    }
}

export default EntitiesList;
