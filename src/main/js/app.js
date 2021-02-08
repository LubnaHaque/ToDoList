import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import ListTaskComponent from "./components/ListTaskComponent.jsx";

class App extends React.Component{
    render(){
        return(
            <Router>
                <Switch>
                    <Route exact path="/">
                        <ListTaskComponent/>
                    </Route>
                </Switch>
            </Router>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById('root'))