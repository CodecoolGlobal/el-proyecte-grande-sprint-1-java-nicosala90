import { useState } from "react";
import BMIValue from "./BMIValue";
import SemiCircleIndicator from "./SemiCircleIndicator";

function InputCard() {

    const [client, setClient] = useState({
        "clientId": "",
        "dateOfBirth": "",
        "weight": "",
        "height": ""
    })
    const [value, setValue] = useState(0);
    const [age, setAge] = useState(0);

    function handleClientIdChange(e) {
        setClient
            ({
                ...client,
                clientId: e.target.value
            })
    }
    function handleDateOfBirthChange(e) {
        setClient
            ({
                ...client,
                dateOfBirth: e.target.value
            })
    }
    function handleWeightChange(e) {
        setClient
            ({
                ...client,
                weight: e.target.value
            })
    }
    function handleHeightChange(e) {
        setClient
            ({
                ...client,
                height: e.target.value
            })
    }

    function submitClientData(client) {
        if (client["dateOfBirth"] !== "" && client["weight"] !== "" && client["height"] !== "") {
            if (client.clientId === "") { client.clientId = 0; } else { client.clientId = parseFloat(client.clientId); }
            const clientData = {
                ...client,
                clientId: client.clientId == "" ? -1 : parseFloat(client.clientId),
                dateOfBirth: client.dateOfBirth,
                weight: parseFloat(client.weight),
                height: parseFloat(client.height)
            };

            fetch(`/api/client/client-age/${client.clientId}`)
                .then(response => response.json())
                .catch(error => {
                    console.error('Error fetching client age:', error);
                })
                .then(data => {
                    setAge(data);
                })

            fetch(`/api/client/registeredBMI/${client.clientId}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(clientData)
            })
                .then(res => res.json())
                .then(res => setValue(res));

            setClient
                ({
                    "clientId": "",
                    "dateOfBirth": "",
                    "weight": "",
                    "height": ""
                });

        }
    }

    return (
        <div className="container-input">
            <div id="input-table">
                <div id="input-fields">
                    <input placeholder="client id" type="number" value={client.clientId} onChange={handleClientIdChange}></input>
                    <input placeholder="dateOfBirth" type="date" value={client.dateOfBirth} onChange={handleDateOfBirthChange}></input>
                    <input placeholder="weight" type="number" value={client.weight} onChange={handleWeightChange}></input>
                    <input placeholder="height" type="number" value={client.height} onChange={handleHeightChange}></input>
                    <button className="submitBtn" onClick={() => { submitClientData(client); }}>Calculate</button>

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
                    <SemiCircleIndicator value={value} age={age} />
                </div>
                : <></>
            }
        </div>
    )
}
export default InputCard;
