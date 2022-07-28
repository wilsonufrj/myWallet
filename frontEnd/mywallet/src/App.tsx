import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './pages/Home/index';
import Month from './pages/Month/index';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";     

import { Provider } from 'react-redux';
import { store } from './redux/store';
import HistoricalTransaction from './pages/HistoricalTransaction';
import Sidebar from './pages/components/Sidebar/App';
import Teste from './pages/Teste';


function App() {
  return (
    <Provider store={store}>
      <Router>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/teste' element={<Teste/>}/>
            <Route path='month/:monthId' element={<Month/>}/>
            <Route path='historical/:monthId' element={<HistoricalTransaction/>}/>
        </Routes>
      </Router>
    </Provider>
  );
}

export default App;
