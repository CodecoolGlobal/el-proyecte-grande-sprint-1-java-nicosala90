import React from "react";
import { useState } from 'react';

function Contact() {
    const [show, setShow] = useState(true);

    function changeState() {
        setShow(!show);
    }

    function resetState() {
        setShow(!show);
        setMessage({
            "clientName": "",
            "email": "",
            "subject": "",
            "message": "",
        });
    }

    const [message, setMessage] = useState({
        "clientName": "",
        "email": "",
        "subject": "",
        "message": "",
    });

    function handleClientNameChange(e) {
        setMessage({
            ...message,
            clientName: e.target.value
        });
    }

    function handleEmailChange(e) {
        setMessage({
            ...message,
            email: e.target.value
        });
    }

    function handleSubjectChange(e) {
        setMessage({
            ...message,
            subject: e.target.value
        });
    }

    function handleMessageChange(e) {
        setMessage({
            ...message,
            message: e.target.value
        });
    }

    function sendMessage() {
        console.log("Dear " + message.clientName + " thanks for your attantion!\n" +
            "Your message was : " + message.message);

        fetch('/api/client/message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        })

    }

    return (
        <div className="container-contact">
            <h1>Contact Us</h1>
            {show ? (<div id="login-table" >
                <div id="login-fields">
                    <label>
                        <input placeholder="Client name" value={message.clientName} onChange={handleClientNameChange} />
                    </label>
                    <label>
                        <input placeholder="E-mail" value={message.email} onChange={handleEmailChange} />
                    </label>
                    <label>
                        <input placeholder="Subject" value={message.subject} onChange={handleSubjectChange} />
                    </label>
                    <label>
                        <textarea placeholder="Message" rows="10" value={message.message} onChange={handleMessageChange} />
                    </label>
                    <div>
                        <button className="submitBtn" onClick={() => {
                            if (message.clientName === "" || message.email === "" || message.subject === "" || message.message === "") {
                                console.log("Data is missing!");
                            } else {
                                changeState();
                                sendMessage();
                            }
                        }}>Send</button>
                    </div>
                </div>
            </div>
            ) : (
                <div>
                    <p>We appreciate you contacting us. One of our colleagues
                        will get back in touch with you soon! Have a great day!
                    </p>
                    <button className="submitBtn" onClick={() => resetState()}>Send another message</button>
                </div>
            )
            }
        </div>
    )
}
export default Contact;