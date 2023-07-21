import React from 'react';
import './genericFormButton.css'

const GenericFormButton = ({ text, onClick }) => {
  return (
    <div className="container-generic-form-btn">
      <button type="submit" className="generic-form-btn" onClick={onClick}>
        {text}
      </button>
    </div>
  );
};

export default GenericFormButton;

