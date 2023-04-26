import { useEffect, useState } from "react";


function Progress(clientId) {
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
          <tr>
            {Object.values(listBMI).map((bmi, index) =>
              <tr>
                <td key={index}>{bmi.localDate}</td>
                <td >{bmi.bmiValues.toFixed(2)}</td>
              </tr>)}
          </tr>
        </tbody>

      </table>
    </div>
  );
}
export default Progress;

