import axios from 'axios';

const BASE_URL = 'http://localhost:8091/crime';

export const predictCrime = async (data) => {
  const response = await axios.post(BASE_URL, data);
  return response.data;
};

export const getAllRecords = async () => {
  const response = await axios.get(`${BASE_URL}/allrecord`);
  return response.data;
};

export const getByYear = async (year) => {
  const response = await axios.get(`${BASE_URL}/year/${year}`);
  return response.data;
};

export const getByCrimeRateLessThan = async (value) => {
  const response = await axios.get(`${BASE_URL}/crimerate/${value}`);
  return response.data;
};

export const getByUnemploymentRateLessThan = async (value) => {
  const response = await axios.get(`${BASE_URL}/unemployment/${value}`);
  return response.data;
};
