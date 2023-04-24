import { Link } from "react-router-dom";

function NavBar() {

    return (
        <div id="nav-bar">
            <div id="img-logo">
                <img className="logo" src="/logo-text.png" alt="B-Fit" width="100" height="100"></img>
            </div>
            <div className="nav-options">
            <div class="dropdown">
                    <button class="dropbtn">Sign in
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                    <Link className="link-component" to="/login">Login</Link>
                    <Link className="link-component" to="/signin">Sign In</Link>
                    </div>
                </div>
                <Link className="link-component" to="/">Home</Link>
                <Link className="link-component" to="/calculator">BMI Calculator</Link>
                <Link className="link-component" to="/progress">Your Progress</Link>
                <Link className="link-component" to="/contact">Contact</Link>
                
            </div>
        </div>
    )
}
export default NavBar;
