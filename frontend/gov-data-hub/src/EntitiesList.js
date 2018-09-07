import React, { Component } from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

class EntitiesList extends Component {
    constructor() {
        super();
        this.state = {
            entities: []
        };
    }
    render() {
        const entities = this.state.entities.map(e => <TableRow key={e.id}><TableCell>{e.name}</TableCell><TableCell>{e.type}</TableCell><TableCell>{e.description}</TableCell></TableRow>);
        return (
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
        );
    }
    componentDidMount() {
        fetch('http://localhost:8080/entities')
            .then(resp => resp.json())
            .then(data => {this.setState({entities: data})});
    }
}

export default EntitiesList;
