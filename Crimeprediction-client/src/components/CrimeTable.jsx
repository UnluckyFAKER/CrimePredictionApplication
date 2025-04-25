import React from 'react';
import '../styles/CrimeTable.css';

const CrimeTable = ({ data }) => {
  if (!data.length) return <p>No records found.</p>;

  return (
    <table className="crime-table">
      <thead>
        <tr>
          <th>Year</th>
          <th>Population</th>
          <th>Unemployment Rate</th>
          <th>Poverty Rate</th>
          <th>Education Index</th>
          <th>Crime Rate</th>
        </tr>
      </thead>
      <tbody>
        {data.map((crime, idx) => (
          <tr key={idx}>
            <td>{crime.year}</td>
            <td>{crime.population}</td>
            <td>{crime.unemploymentRate}</td>
            <td>{crime.povertyRate}</td>
            <td>{crime.educationIndex}</td>
            <td>{crime.crimeRate}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default CrimeTable;
