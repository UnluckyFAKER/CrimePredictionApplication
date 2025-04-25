import React, { useState } from "react";
import { predictCrime } from "../services/api";
import "../styles/CrimeForm.css";

const CrimeForm = () => {
  const [formData, setFormData] = useState({
    Year: "",
    Population: "",
    Unemployment_Rate: "",
    Poverty_Rate: "",
    Education_Index: "",
  });

  const [result, setResult] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await predictCrime(formData);
    setResult(response);
  };

  return (
    <div className="form-container">
      <h2>Predict Crime Rate</h2>
      <form onSubmit={handleSubmit}>
        {Object.keys(formData).map((key) => (
          <div className="form-group" key={key}>
            <label htmlFor={key}>{key.replace(/_/g, " ")}</label>
            <input
              type="text"
              id={key}
              name={key}
              value={formData[key]}
              onChange={handleChange}
              required
            />
          </div>
        ))}
        <button type="submit">Predict</button>
      </form>
      {result && <p className="result">{result}</p>}
    </div>
  );
};

export default CrimeForm;
