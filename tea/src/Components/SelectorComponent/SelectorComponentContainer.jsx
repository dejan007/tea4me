import React, { useEffect, useState } from 'react';
import SelectorComponent from './SelectorComponent';
import { makeStyles } from '@material-ui/core/styles';

const SelectorComponentContainer = ({ defaultConditions, setTeasToShow, idsToSend, setIdsToSend }) => {

  const [conditions, setConditions] = useState({});
  const [activeConditions, setActiveConditions] = useState([]);

  const {REACT_APP_HOME} = process.env;


  useEffect(() => {
    
    if (idsToSend.length > 0 ) {
      fetch(REACT_APP_HOME + "get-teas", {
        method: "POST",
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(idsToSend)
      }).then((res) => res.json()).then((json) =>{
        setTeasToShow(json);
      });
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [idsToSend]);

  useEffect(() => {
    defaultConditions.forEach((condition) => {
      conditions[condition.name] = false;
    })
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [defaultConditions]);

  const handleChange = (event) => {
    saveActiveCondition(event.target.name, event.target.checked);
    setConditions({ ...conditions, [event.target.name]: event.target.checked });

    if (event.target.checked) {
      setIdsToSend([...idsToSend, event.target.id]);
    } else {
      setIdsToSend(idsToSend.filter((id) => id !== event.target.id))
    }

    if (idsToSend.length === 1) {
      setTeasToShow([]);
    }
  };

  const useStyles = makeStyles((theme) => ({
    root: {
      display: 'flex',
    },
    formControl: {
      margin: theme.spacing(3),
    },
  }));

  const saveActiveCondition = (condition, checked) => {
    let tempArray = activeConditions;

    if (checked === true) {
      tempArray.push(condition);
    } else {
      tempArray = activeConditions.filter((el) => el !== condition);
    }
    setActiveConditions(tempArray);
  }

  return (
    <div >
      <SelectorComponent
        useStyles={useStyles}
        conditions={conditions}
        setConditions={setConditions}
        handleChange={handleChange}
        defaultConditions={defaultConditions}
        activeConditions={activeConditions}
      />
    </div>
  );
};

export default SelectorComponentContainer;