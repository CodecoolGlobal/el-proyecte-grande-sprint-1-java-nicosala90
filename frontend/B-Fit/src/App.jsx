import './App.css';
import Footer from './components/Footer';
import NavBar from './components/NavBar';
import Contact from './components/Contact';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import CalculatorBMI from './components/CalculatorBMI';
import Home from './components/Home';
import Progress from './components/Progress';
import SignIn from './components/SignIn';
import Login from './components/Login';


function App() {
  return (
    <div className="root">
      <Router>
        <NavBar />
        <Routes>
          <Route path="/contact" element={<Contact />} />
          <Route path="/" element={<Home />} />
          <Route path="/progress" element={<Progress/>}/>
          <Route path='/calculator' element={<CalculatorBMI/>}/>
          <Route path='/signin' element={<SignIn/>}/>
          <Route path='/login' element={<Login/>}/>
        </Routes>
        <Footer />
      </Router>
    </div>
  )
}

export default App;
