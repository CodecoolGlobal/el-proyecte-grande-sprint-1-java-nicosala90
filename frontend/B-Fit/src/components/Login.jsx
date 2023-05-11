import { useState } from "react";
function Login() {

    const [client, setClient] = useState({
        "clientName": "",
        "password": ""
    })
    const [value, setValue] = useState(0);

    function handleClientName(e) {
        setClient
            ({
                ...client,
                clientName: e.target.value
            })
    }
    function handlePassword(e) {
        setClient
            ({
                ...client,
                password: e.target.value
            })
    }

    function submitClientCheckerData(client) {

        if (client["clientName"] !== "" && client["password"] !== "") {

            const clientData = {
                ...client,
                clientName: client.clientName,
                password: client.password
            };

            fetch(`/api/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },

                body: JSON.stringify(clientData)
            })
                
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.text();
                })
                .then(token => {
                    //the token is a string not a JSON object
                    localStorage.setItem('jwtToken', token.split(',')[0]);
                })
                .catch(error => {
                    console.error('There was a problem with the fetch operation:', error);
                });


            setClient
                ({
                    "clientName": "",
                    "password": ""
                });

        }
    }

    return (
        <div className="container-login">
            <div id="login-table">
                <div id="login-fields">
                    <input placeholder="clientName" type="text" value={client.clientName} onChange={handleClientName}></input>
                    <input placeholder="password" type="password" value={client.password} onChange={handlePassword}></input>
                    <button className="submitBtn" onClick={() => { submitClientCheckerData(client); }}>Login</button>
                </div>
            </div>
        </div>
    )
}
export default Login;

