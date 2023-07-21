import React from 'react';
import './inputFormStyle.css'

const InputForm = ({ type, value, onChange, placeholder }) => {
  const handleInputChange = (e) => {
    onChange(e.target.value);
  };

  return (
    <div className="wrap-input">
      
      <input
        className={value !== "" ? 'has-val input' : 'input'}
        type={type}
        value={value}
        onChange={handleInputChange}
      />

      <span className="focus-input" data-placeholder={placeholder}></span>
    </div>
  );
};

export default InputForm;
