from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

# Load trained model
model = joblib.load('crime_prediction_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()

    try:
        year = data['Year']
        population = data['Population']
        unemployment_rate = data['Unemployment_Rate']
        poverty_rate = data['Poverty_Rate']
        education_index = data['Education_Index']

        features = np.array([[year, population, unemployment_rate, poverty_rate, education_index]])
        prediction = model.predict(features)[0]

        return jsonify({
            'Predicted_Crime_Rate': round(prediction, 2)
        })

    except KeyError as e:
        return jsonify({'error': f'Missing input field: {e}'}), 400

if __name__ == '__main__':
    app.run(debug=True)