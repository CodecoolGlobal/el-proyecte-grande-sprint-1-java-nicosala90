import { useState } from "react";
import BMIValue from "./BMIValue";
import SemiCircleIndicator from "./SemiCircleIndicator";

function InputCard() {

    const [user, setUser] = useState({
        "gender": "",
        "age": "",
        "weight": "",
        "height": ""
    })
    const [value, setValue] = useState(0);
    const [error, setError] = useState("Mass was invalid.");

    function handleGender(e) {
        setUser({
            ...user,
            gender: e.target.value
        })
    }
    function handleAgeChange(e) {
        setUser({
            ...user,
            age: e.target.value
        })
    }
    function handleWeightChange(e) {
        setUser({
            ...user,
            weight: e.target.value
        })
    }
    function handleHeightChange(e) {
        setUser({
            ...user,
            height: e.target.value
        })
    }

    function submitUserData(user) {
        setError(null);

        // move valudation to state changers?
        if (user["gender"] !== "" && user["age"] !== "" && user["weight"] !== "" && user["height"] !== "") {

            const userData = {
                ...user,
                age: parseFloat(user.age),
                weight: parseFloat(user.weight),
                height: parseFloat(user.height)
            };

            fetch('/api/user/actual-user', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            })
                .then(res => res.json())
                .then(res => {
                    setValue(res)
                    setUser({
                        "gender": "",
                        "age": "",
                        "weight": "",
                        "height": ""
                    });
                })
                .catch(err => {
                    setError(e);
                });
        }
    }

        return (
            <div className="container">
                <div id="input-table">
                    {error !== null ? <div className="error">{error}</div> : <></>}
                    <div id="input-fields">
                        <select name="genders" id="cars" value={user.gender} onChange={handleGender}>
                            <option value="">-Choose a gender-</option>
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </select>
                        <input placeholder="age" type="number" value={user.age} onChange={handleAgeChange}></input>
                        <input placeholder="weight" type="number" value={user.weight} onChange={handleWeightChange}></input>
                        <input placeholder="height" type="number" value={user.height} onChange={handleHeightChange}></input>
                        <button id="submitBtn" onClick={() => { submitUserData(user); }}>Calculate</button>

                        {value > 0
                         ?
                         <div>
                             <BMIValue value={value} />
                         </div>
                         : <></>

                        }
                    </div>

                </div>
                {value > 0 ?
                 <div id="result-table">
                     <SemiCircleIndicator value={value} />
                 </div>
                 : <></>
                }
            </div>
        )
    }
export default InputCard;
