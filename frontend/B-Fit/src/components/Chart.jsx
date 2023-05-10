import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid, Legend } from "recharts";
//import { Line } from "react-chartjs-2";
function Chart({ listBMI }) {

  return (
    <LineChart
      width={1320}
      height={700}
      data={listBMI}
      margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
      style={{ backgroundColor: 'white' }}
    >
      <YAxis dataKey="bmiValues"  label={{ value: 'BMI', angle: -90, position: 'insideLeft', fontSize: 15}} tick={{ fontSize: 20 }}/>
      <XAxis  dataKey="localDate" label={{  position: 'insideBottom', fontSize: 15 }} tick={{ fontSize: 10 }}/>
      <CartesianGrid strokeDasharray="3 3" />
      <Tooltip />
      <Legend verticalAlign="top" height={36} />
      <Line  type="linear" dataKey="bmiValues" stroke="#F4A460" strokeWidth={4}  />
    </LineChart>
  );
}
export default Chart;
// <Line  dataKey="localDate" stroke="#8784d8" />