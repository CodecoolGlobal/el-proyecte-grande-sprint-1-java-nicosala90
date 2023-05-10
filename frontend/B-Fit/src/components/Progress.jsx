import { useEffect, useState } from "react";
import Chart from "./Chart";

function Progress(clientName) {
  const [listBMI, setListBMI] = useState({});

  useEffect((clientId) => {
    // fetch(`/api/client/bmi-list/${clientId}`)
    fetch(`/api/client/bmi-list/1`)
      .then(response => response.json())
      .catch(error => {
        console.error('Error fetching BMI list:', error);
      })
      .then(data => {
        setListBMI(data);
      })

  }, []);

  return (
    <div >
      <table className="list-BMI">
        <thead>
          <tr>
            <th>Date</th>
            <th>BMI</th>
          </tr>
        </thead>
        <tbody>
          {Object.values(listBMI).map((bmi, index) =>
            <tr key={index}>
              <td >{bmi.localDate}</td>
              <td legend="BMI">{bmi.bmiValues.toFixed(2)}</td>
            </tr>)}
        </tbody>
      </table>
      <div className="chart">
        <Chart listBMI={listBMI} />
      </div>
    </div>
  );
}
export default Progress;

