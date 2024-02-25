import { FunctionComponent } from 'react'; 
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux';
import { IRootState } from '../../data/store';
import { authenticateUser } from '../../data/userSlice';
import { useCookies } from 'react-cookie';


export const LoginComponent: FunctionComponent = ({
    ...props
}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [cookies, setCookie, removeCookie] = useCookies(['access_token']);
    const navigate = useNavigate();

    const dispatch = useDispatch();
    const user = useSelector((state: IRootState) => state.user);

    console.log(user);
    return(
        <div>
            {
                error &&
                <>
                    <label>{error}</label> 
                    <br/>
                </>
            }
            <br />
            <form>
                <input id='username' type='text' placeholder='username' onChange={event => setUsername(event.target.value)} value={username} /><br />
                <br />
                <input type='password' placeholder='password'  onChange={event => setPassword(event.target.value)} value={password} /><br />
                <br />
                <button type="button" onClick={clickHandler}>Submit</button>
            </form>
        </div>
    )

    function clickHandler() {
        var payload = {
            "username": username,
            "password": password
        };
        axios.post('http://localhost:8080/api/signin', payload, 
        {
            headers: {
                "Content-Type": 'application/json'
            }
        })
        .then((response: any) => {
            if(response.headers.hasAuthorization){
                let authHeader = response.headers.authorization;
                const access_token = authHeader.split(/(\s+)/)[2];
                console.log(access_token);
                console.log(response.data);

                dispatch(authenticateUser(response.data));
                setCookie('access_token', access_token)
                navigate('/profile');
            }
          }, (error) => {
            console.log(error);;
            setError("Forking error");
        });
    }
}

