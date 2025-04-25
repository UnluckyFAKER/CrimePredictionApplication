import React, { useEffect, useState } from 'react';
import {
  getAllRecords,
  getByYear,
  getByCrimeRateLessThan,
  getByUnemploymentRateLessThan
} from '../services/api';
import CrimeTable from '../components/CrimeTable';
import '../styles/Records.css';

const Records = () => {
  const [data, setData] = useState([]);
  const [year, setYear] = useState('');
  const [crimeRate, setCrimeRate] = useState('');
  const [unempRate, setUnempRate] = useState('');

  const fetchAll = async () => {
    try {
      const res = await getAllRecords();
      setData(res);
    } catch (err) {
      console.error('Failed to fetch all records:', err.message);
    }
  };

  const handleYearSearch = async () => {
    try {
      const res = await getByYear(year);
      setData(res);
    } catch (err) {
      console.error('Failed to fetch by year:', err.message);
    }
  };

  const handleCrimeRateSearch = async () => {
    try {
      const res = await getByCrimeRateLessThan(crimeRate);
      setData(res);
    } catch (err) {
      console.error('Failed to fetch by crime rate:', err.message);
    }
  };

  const handleUnempSearch = async () => {
    try {
      const res = await getByUnemploymentRateLessThan(unempRate);
      setData(res);
    } catch (err) {
      console.error('Failed to fetch by unemployment rate:', err.message);
    }
  };

  useEffect(() => {
    fetchAll();
  }, []);

  return (
    <div className="records-container">
      <h2>Crime Records</h2>

      <div className="filters">
        <div>
          <input
            type="number"
            placeholder="Filter by Year"
            value={year}
            onChange={(e) => setYear(e.target.value)}
          />
          <button onClick={handleYearSearch}>Search</button>
        </div>

        <div>
          <input
            type="number"
            placeholder="Crime Rate <"
            value={crimeRate}
            onChange={(e) => setCrimeRate(e.target.value)}
          />
          <button onClick={handleCrimeRateSearch}>Search</button>
        </div>

        <div>
          <input
            type="number"
            placeholder="Unemployment Rate <"
            value={unempRate}
            onChange={(e) => setUnempRate(e.target.value)}
          />
          <button onClick={handleUnempSearch}>Search</button>
        </div>

        <div>
          <button onClick={fetchAll}>Reset</button>
        </div>
      </div>

      <CrimeTable data={data} />
    </div>
  );
};

export default Records;
