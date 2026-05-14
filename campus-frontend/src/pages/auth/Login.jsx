import { useState } from "react";
import { useNavigate } from "react-router-dom";

import { loginUser } from "../../services/authService";

const Login = () => {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    try {

      const response = await loginUser(formData);

      console.log(response);

      localStorage.setItem(
        "token",
        response.token
      );

      alert("Login Successful!");

      navigate("/jobs");

    } catch (error) {

      console.log(error);

      alert("Invalid Credentials");
    }
  };

  return (
    <div
      style={{
        height: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background: "#f5f7fb",
      }}
    >

      <form
        onSubmit={handleLogin}
        style={{
          background: "white",
          padding: "40px",
          width: "350px",
          borderRadius: "10px",
          boxShadow: "0px 0px 10px rgba(0,0,0,0.1)",
        }}
      >

        <h2
          style={{
            textAlign: "center",
            marginBottom: "20px",
            color: "#2563eb",
          }}
        >
          Login
        </h2>

        <input
          type="email"
          name="email"
          placeholder="Enter Email"
          value={formData.email}
          onChange={handleChange}
          required
          style={inputStyle}
        />

        <input
          type="password"
          name="password"
          placeholder="Enter Password"
          value={formData.password}
          onChange={handleChange}
          required
          style={inputStyle}
        />

        <button
          type="submit"
          style={buttonStyle}
        >
          Login
        </button>

      </form>
    </div>
  );
};

const inputStyle = {
  width: "100%",
  padding: "12px",
  marginBottom: "15px",
  border: "1px solid #ccc",
  borderRadius: "5px",
};

const buttonStyle = {
  width: "100%",
  padding: "12px",
  background: "#2563eb",
  color: "white",
  border: "none",
  borderRadius: "5px",
  cursor: "pointer",
  fontSize: "16px",
};

export default Login;