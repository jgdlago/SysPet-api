import React, { useState } from 'react';
import './inputInfo.css';
import classNames from 'classnames';

function InputInfo({ value, isEditing, onChange, title }) {
  const [editedValue, setEditedValue] = useState(value);

  const handleInputChange = (event) => {
    setEditedValue(event.target.value);
  };

  const handleInputBlur = () => {
    if (onChange) {
      onChange(editedValue);
    }
  };

  return (
    <div className="wrap-inputInfo">
      <span>{title}: </span>
      <br></br>
      <input
        className={classNames('inputInfo', { 'inputInfo-editing': isEditing })}
        type="text"
        value={editedValue}
        onChange={handleInputChange}
        onBlur={handleInputBlur}
        disabled={!isEditing}
      />
    </div>
  );
}

export default InputInfo;
