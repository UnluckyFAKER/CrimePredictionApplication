import React from 'react';
import CrimeForm from '../components/CrimeForm';
import '../styles/Home.css';

const Home = () => {
  return (
    <div className="home-container">
      <h1>Crime Prediction System</h1>
      <CrimeForm />
    </div>
  );
};

export default Home;
