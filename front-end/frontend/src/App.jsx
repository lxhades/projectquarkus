
import axios from "axios";
import Home from "./pages/home";
import StudentHP from "./pages/student/studentHP";
import ErrorPage from "./pages/errorpage";
import QlStudent from "./pages/admin/qlStudent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
const API = "http://localhost:8080/students";

function App() {
  
  return <>
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/student" element={<StudentHP />} />
      <Route path="/admin/student" element={<QlStudent />} />
      <Route path="*" element={<ErrorPage />} />
    </Routes>
  </BrowserRouter>
  </>
}
export default App;