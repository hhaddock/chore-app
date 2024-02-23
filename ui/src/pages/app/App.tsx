import './App.css';
import { SideBar } from '../../components/sidebar/sidebar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from '../home/home';
import Admin from '../admin/admin';
import Profile from '../profile/profile';
import Login from '../login/login';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
        
      </header>
      <div className='container'>
        <BrowserRouter>
          <SideBar loggedIn={true} />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/admin" element={<Admin />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;
