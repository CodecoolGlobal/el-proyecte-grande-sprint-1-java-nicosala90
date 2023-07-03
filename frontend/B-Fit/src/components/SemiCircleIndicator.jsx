import { useState, useEffect } from "react";
import ReactSpeedometer from "react-d3-speedometer"

function SemiCircleIndicator({value, age}) {
  /*    Age	Underweight	Normal weight	Overweight	Obese	Severely obese
     18-24	<18.5		18.5-24.9	25-29.9	3	0-39.9		≥40
     25-34	<19		19-24.9		25-29.9		30-39.9		≥40
     35-44	<20		20-24.9		25-29.9		30-39.9		≥40
     45-54	<21		21-24.9		25-29.9		30-39.9		≥40
     55-64	<22		22-24.9		25-29.9		30-39.9		≥40
     65-74	<23		23-24.9		25-29.9		30-39.9		≥40
     ≥75	<24		24-24.9		25-29.9		30-39.9		≥40 */

     const [normalBmiMinimumValue, setNormalBmiMinimumValue] = useState(18.5)
     const [segmentStops, setSegmentStops] = useState([10, 18.5, 24.9, 29.9, 39.9, 50]);

     useEffect(() => {
      calculateNormalMinimumBmiValue();
    }, [age]);

     function calculateNormalMinimumBmiValue(){
      if(age < 25){
        setNormalBmiMinimumValue(18.5)
      } else if(age < 35){
        setNormalBmiMinimumValue(19.0)
      } else if(age < 45){
        setNormalBmiMinimumValue(20.0)
      } else if(age < 55){
        setNormalBmiMinimumValue(21.0)
      } else if(age < 65){
        setNormalBmiMinimumValue(22.0)
      } else if (age < 75){
        setNormalBmiMinimumValue(23.0)
      } else {
        setNormalBmiMinimumValue(24.0)
      }
      console.log(age)
     }

     useEffect(() => {
      const updatedStops = [10, normalBmiMinimumValue, 24.9, 29.9, 39.9, 50];
      setSegmentStops(updatedStops);
    }, [normalBmiMinimumValue]);
     
  return (
    <div>
      <ReactSpeedometer
        value={value > 40 ? value = 50 : value < 10 ? value = 10 : value}
        minValue={10}
        maxValue={50}
        width={800}
        height={450}
        ringWidth={30}
        currentValueText="Actual health state"
        segments={5}
        needleTransitionDuration={9000}
        needleTransition="easeElastic"
        customSegmentStops={segmentStops}
        segmentColors={[
          "#87CEFA",
          "#00FF00",
          "#FFFF00",
          "#FF8C00	",
          "#FF0000",
        ]}
        customSegmentLabels={[
          {
            text: "Underweight",
            position: "OUTSIDE",
            color: "#555",
            fontSize: "19px",
          },
          {
            text: "Normal weight",
            position: "OUTSIDE",
            color: "#555",
            fontSize: "19px"
          },
          {
            text: "Overweight",
            position: "OUTSIDE",
            color: "#555",
            fontSize: "19px",
          },
          {
            text: "Obese",
            position: "OUTSIDE",
            color: "#555",
            fontSize: "19px"
          },
          {
            text: "Severely obese",
            position: "OUTSIDE",
            color: "#555",
            fontSize: "19px"
          },
        ]}
      />
    </div>
  )
}
export default SemiCircleIndicator;