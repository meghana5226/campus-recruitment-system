import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "../pages/Home";

import Login from "../pages/auth/Login";

const AppRoutes = () => {
  return (
    <BrowserRouter>

      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/login" element={<Login />} />

      </Routes>

    </BrowserRouter>
  );
};

export default AppRoutes;