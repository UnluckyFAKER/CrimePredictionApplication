import React from 'react';
import { Routes, Route, Link, useLocation } from 'react-router-dom';
import Home from './pages/Home';
import Records from './pages/Records';
import './App.css';

const App = () => {
  const location = useLocation();

  return (
    <>
      <nav>
        <Link to="/" className={location.pathname === '/' ? 'active' : ''}>Home</Link>
        <Link to="/records" className={location.pathname === '/records' ? 'active' : ''}>View Records</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/records" element={<Records />} />
      </Routes>
    </>
  );
};

export default App;

