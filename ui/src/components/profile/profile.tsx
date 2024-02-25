import { FunctionComponent } from 'react'; 
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { IRootState } from '../../data/store';

export interface ProfileProps extends HTMLDivElement {
    user: any
}

export const Profile: FunctionComponent = ({
    
}) => { 
    const user = useSelector((state: IRootState) => state.user);

    return(
        <>
            <div>
                <p>Username: {user.user.username}</p>
                <p>Email: {user.user.email}</p>
                {user.user.roles.map((role:any, index) => <p key={index}>Role: {role.name}</p>)}
            </div>
        </>
    )
}