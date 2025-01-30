import axios from 'axios';
import { Button } from 'primereact/button';
import { Calendar } from 'primereact/calendar';
import { Card } from 'primereact/card';
import { FloatLabel } from 'primereact/floatlabel';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import React, { useState } from 'react';

interface Carteira {
    nome: string;
}

interface UserForm {
    nome: string;
    dataNascimento: Date;
    email: string;
    senha: string;
    carteiras: Array<Carteira>

}

const Login: React.FC = () => {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [form, setForm] = useState<UserForm>({
        nome: '',
        dataNascimento: new Date(),
        email: '',
        senha: '',
        carteiras: []
    });
    const handleLogin = () => {
        // Handle login logic here
        console.log('Name:', name);
        console.log('Password:', password);
    };

    const handlerCadastro = () => {
        axios.post('http://localhost:8082/api/usuario', form)
            .then(() => {
                console.log('Usuario cadastrado no banco de dados')
            })
    }

    const footer = () => {
        return (
            <Button onClick={handleLogin}>Login</Button>
        )
    }

    const footerCadastro = () => {
        return (
            <Button onClick={handlerCadastro}>Cadastrar</Button>
        )
    }

    return (
        <div className='flex'>
            <Card title="Login Carteira" footer={footer} className='mr-5'>
                <div>
                    <FloatLabel className='mb-5'>
                        <InputText id="username" value={name} onChange={(e) => setName(e.target.value)} />
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
            <Card title="Cadastro Carteira" footer={footerCadastro}>
                <div>
                    <FloatLabel className='mb-5'>
                        <InputText id="username" value={form.nome} onChange={(e) => setForm({ ...form, nome: e.target.value })} />
                        <label htmlFor="username">Nome</label>
                    </FloatLabel>

                    <FloatLabel className='mb-5'>
                        <Calendar id='dataNascimento' value={form.dataNascimento} onChange={(e) => setForm({ ...form, dataNascimento: e.value ?? new Date() })} />
                        <label htmlFor="dataNascimento">Data de Nascimento</label>
                    </FloatLabel>

                    <FloatLabel className='mb-5'>
                        <InputText id="email" value={form.email} onChange={(e) => setForm({ ...form, email: e.target.value })} />
                        <label htmlFor="email">Email</label>
                    </FloatLabel>

                    <FloatLabel className='mb-3'>
                        <Password value={form.senha}
                            onChange={(e) => setForm({ ...form, senha: e.target.value })}
                            feedback={false}
                            toggleMask />
                        <label htmlFor="password">Password</label>
                    </FloatLabel>
                </div>
            </Card>
        </div>
    );
};

export default Login;