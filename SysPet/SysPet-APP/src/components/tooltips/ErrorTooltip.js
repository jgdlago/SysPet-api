import React, { useState, useEffect } from 'react';
import './errorTooltip.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faExclamation } from '@fortawesome/free-solid-svg-icons';

const ErrorTooltip = ({ message, show }) => {
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    setIsVisible(show);
  }, [show]);

  return (
    <div className={`error-tooltip ${isVisible ? 'show' : ''}`}>
      <FontAwesomeIcon icon={faExclamation} fade style={{ color: "#ff8a00" }} />
      <span className="error-tooltip-content"><strong>&nbsp;{message}</strong></span>
    </div>
  );
};

export default ErrorTooltip;


