import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Home from './pages/Home/App';
import SideBar from './pages/SideBar/App';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";     
import Adding from './pages/Adding/App';
import { Provider } from 'react-redux';
import { store } from './redux/store';


function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='sidebar' element={<SideBar/>}/>
            <Route path='adding' element={<Adding/>}/>
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
