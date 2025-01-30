import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";
import "/node_modules/primeflex/primeflex.css"

import { Provider } from 'react-redux';
import { store } from './redux/store';
import Home from './pages/Home/home';
import XLibs from './pages/Features/Xlibs/Xlibs';
import Login from './pages/Home/Login/Login';


function App() {
  return (
    <Provider store={store}>
      <Router>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/Login' element={<Login />} />
        </Routes>
      </Router>
    </Provider>
  );
}

export default App;
