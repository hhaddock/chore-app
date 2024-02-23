import React, { FunctionComponent } from 'react'; 
import './sidebar.css';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { createSelector } from '@reduxjs/toolkit';
import { IRootState } from '../../data/store';


enum USER_ROLE {
    ROLE_ADMIN,
    ROLE_USER
}

type SideBarProps = {
    loggedIn: boolean
}


export const SideBar: FunctionComponent<SideBarProps> = ({
    loggedIn
}) => {
    const user = useSelector((state: IRootState) => state.user);
    console.log(user);
    return(
        <>
            <div className='sidebar'>
                <h1 className='title'>Sweepr</h1>
                <hr />
                <nav>
                <ul>
                    <li>
                        <Link to="/">
                            Home
                        </Link>
                    </li>
                    <li>
                        <Link to="/Login">
                            Login
                        </Link>
                    </li>
                    <li>
                        <Link to="/admin">
                            Admin
                        </Link>
                    </li>
                    {loggedIn && 
                    <li>
                        <Link to="/profile">
                            Profile
                        </Link>
                    </li>
                    }
                </ul>
            </nav>
            </div>
        </>
    );
}