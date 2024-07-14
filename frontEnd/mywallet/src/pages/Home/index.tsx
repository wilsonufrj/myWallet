import React, { useEffect } from 'react';
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import Wallet from '../../components/month/Wallet';
import { getAllWallets } from './homeSlice';
import type { RootState } from '../../redux/store'


export default function Home() {

    const dispatch = useAppDispatch()
    const wallets = useAppSelector((state: RootState) => state.home.wallets)
    
    useEffect(() => {   
        dispatch(getAllWallets)
        console.log(wallets)
    })

    return (
        <div>
            <div className='grid'>{/* 
                {
                    wallets?.map((wallet) => {
                        return (
                            <div className='col'>
                                <div className="text-center p-3 border-round-sm bg-primary font-bold">
                                    <Wallet
                                        key={wallet.id}
                                        id={wallet.id}
                                        name={wallet.name}
                                        description={wallet.description} />
                                </div>
                            </div>
                        )
                    })
                }
 */}            <Wallet id={10} name='TESTE' description='NOVO'/>
            </div>


        </div>
    );
}




