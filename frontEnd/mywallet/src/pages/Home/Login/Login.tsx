import React, { useState } from 'react';
import axios from 'axios';
import { Button } from 'primereact/button';
import { Calendar } from 'primereact/calendar';
import { Card } from 'primereact/card';
import { FloatLabel } from 'primereact/floatlabel';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { useAppDispatch } from '../../../redux/hooks';
import { loginUser } from './authSlice';
import { Navigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { RootState } from '../../../redux/store';
import './login.css';


const Login: React.FC = () => {

    const dispatch = useAppDispatch();

    const [name, setName] = useState('');
    const [password, setPassword] = useState('');

    const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);

    if (isAuthenticated) {
        return <Navigate to="/carteira" replace />;
    }

    const handleLogin = () => {
        dispatch(loginUser({ nome: name, senha: password }));
    };

    const footer = () => {
        return (
            <Button onClick={handleLogin}>Login</Button>
        )
    }

    return (
        <div className='flex justify-content-center align-items-center h-screen'>
            <div className='flex'>
                <Card title="Login Carteira" footer={footer} className='mr-5'>
                    <div className=''>
                        <FloatLabel className='mb-4'>
                            <InputText id="username"
                                value={name} onChange={(e) => setName(e.target.value)}
                                className='w-full' />
                            <label htmlFor="username">Username</label>
                        </FloatLabel>
                        <FloatLabel className='mb-3'>
                            <Password value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                feedback={false}
                                toggleMask />
                            <label htmlFor="password">Password</label>
                        </FloatLabel>
                    </div>
                </Card>
            </div>



        </div>
    );
};

export default Login;