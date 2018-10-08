import React, { Component } from 'react';
import Typography from '@material-ui/core/Typography';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

class Entity extends Component {
    constructor(props) {
        super();
        this.state = {
            id: props.entity.id,
            name: props.entity.name,
            type: props.entity.type,
            stats: []
        };
    }
    render() {
        const entityStats = this.state.stats.map(s => <TableRow key={s.id}><TableCell>{s.name}</TableCell><TableCell>{s.value}</TableCell></TableRow>);
        return (<div>
                <Typography variant="title" color="inherit"><p>{this.state.name}</p></Typography>
                <Typography variant="title" color="inherit"><p>Type: {this.state.type}</p></Typography>
                <Typography variant="title" color="inherit" align="center"><p>Stats</p></Typography>
                <Table>
                <TableHead>
                <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Value</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {entityStats}
                </TableBody>
                </Table>
                </div>
        );
    }
    componentDidMount() {
        fetch('http://localhost:8080/entities/' + this.state.id + '/stats')
            .then(resp => resp.json())
            .then(data => {this.setState({stats: data});});
    }
}

export default Entity;
