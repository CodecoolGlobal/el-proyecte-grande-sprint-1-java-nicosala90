import { useState } from "react";

function SignIn() {

    const [client, setClient] = useState({
        "clientName": "",
        "email": "",
        "password": "",
        "dateOfBirth": "",
        "height": ""
    })
    const [value, setValue] = useState(0);

    const [show, setShow] = useState(false)


    function handleClientNameChange(e) {
        setClient
            ({
                ...client,
                clientName: e.target.value
            })
    }
    function handleEmailChange(e) {
        setClient
            ({
                ...client,
                email: e.target.value
            })
    }
    function handlePasswordChange(e) {
        setClient
            ({
                ...client,
                password: e.target.value
            })
    }
    function handleDateOfBirthChange(e) {
        setClient
            ({
                ...client,
                dateOfBirth: e.target.value
            })
    }
    function handleHeightChange(e) {
        setClient
            ({
                ...client,
                height: e.target.value
            })
    }

    function showMoreDataFields() {
        setShow(true)
    }

    function submitClientData(client) {
        const minYear = "1920";
        const maxYear = "2060";
        const minHeight = 1.2;
        const maxHeight = 2.5;
        let yearValue = client.dateOfBirth.substring(0, 4);
        if (yearValue < minYear) { client["dateOfBirth"] = client.dateOfBirth.replace(yearValue, minYear);}
        if (yearValue > maxYear) { client["dateOfBirth"] = client.dateOfBirth.replace(yearValue, maxYear); }
        if (client.height > maxHeight) { client["height"] = maxHeight; }
        if (client.height < minHeight) { client["height"] = minHeight; }
        if (client["clientName"] !== "" && client["email"] !== "" && client["password"] !== "") {
            const clientData = {
                ...client,
                clientName: client.clientName,
                email: client.email,
                password: client.password,
                dateOfBirth: client.dateOfBirth,
                height: client.height
            };

            fetch('/api/client/sign-in', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(clientData)
            })
                .then(res => res.json())
                .then(res => setValue(res));

            console.log(clientData);

            setClient
                ({
                    "clientName": "",
                    "email": "",
                    "password": "",
                    "dateOfBirth": "",
                    "height": ""
                });
            setShow(false);
        }
        else {
            console.log("Data is missing!")
        }
    }

    return (
        <div className="container-login">
            <div id="login-table">
                <div id="login-fields">
                    <input placeholder="clientName" type="text" value={client.clientName} onChange={handleClientNameChange}></input>
                    <input placeholder="email" type="email" value={client.email} onChange={handleEmailChange}></input>
                    <input placeholder="password" type="password" value={client.password} onChange={handlePasswordChange}></input>

                    {show ?
                        <></>
                        :
                        <button className="submitBtn" onClick={() => { submitClientData(client); }}>Sign in</button>
                    }
                    {show ?
                        (
                            <>
                                <label><small>date of birth:</small></label>
                                <input type="date" min="1920-01-01" max="2060-12-31" value={client.dateOfBirth} name="dateOfBirth" onChange={handleDateOfBirthChange} />
                                <label><small><br></br>height in meter:<br></br></small></label>
                                <input placeholder="height" type="text" value={client.height} onChange={handleHeightChange}></input>
                                <button className="submitBtn" onClick={() => submitClientData(client)}>Sign in</button>
                            </>
                        )
                        : null
                    }
                </div>
                {!show ?
                    (
                        <div>
                            <span>
                                <p>If you want to save your personal data for calculate BMI please give more information </p>
                                <button className="submitBtn" onClick={showMoreDataFields}>Click here</button>
                            </span>
                        </div>
                    )
                    : null}
            </div>
        </div>
    )
}
export default SignIn;
