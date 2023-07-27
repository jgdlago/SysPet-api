import React from 'react';
import './inputFormStyle.css';

const InputForm = ({ type, value, onChange, placeholder, onlyNumbers }) => {
  const handleInputChange = (e) => {
    let inputValue = onlyNumbers ? e.target.value.replace(/\D/g, '') : e.target.value;
    
    if (onlyNumbers && inputValue.length > 0) {
      inputValue = inputValue.replace(/^(\d{2})(\d{0,5})(\d{0,4}).*/, '($1) $2-$3');
    }

    const maxLength = onlyNumbers ? 15 : 100;
    if (inputValue.length <= maxLength) {
      onChange(inputValue);
    }
  };

  return (
    <div className="wrap-input">
      <input
        className={value !== "" ? 'has-val input' : 'input'}
        type={type}
        value={value}
        onChange={handleInputChange}
        {...(onlyNumbers && { maxLength: 15, pattern: "[0-9]*", inputMode: "numeric" })}
      />
      <span className="focus-input" data-placeholder={placeholder}></span>
    </div>
  );
};

export default InputForm;
