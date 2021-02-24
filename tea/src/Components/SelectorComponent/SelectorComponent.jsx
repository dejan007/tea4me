import React from 'react';
import FormControl from '@material-ui/core/FormControl';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import Checkbox from '@material-ui/core/Checkbox';
import './selector.scss';

const SelectorComponent = ({ useStyles, conditions, setConditions, handleChange, defaultConditions, activeConditions }) => {

  const classes = useStyles();

  return (
    <>
      <div className="selector-container">
        <div className="selector-headline"> I need a tea for: </div>
        
          <FormControl component="fieldset" className={classes.formControl}>

            <FormGroup>
            <FormHelperText>Pick up to three!</FormHelperText>

            {defaultConditions.map((condition, i) => (
                    <FormControlLabel
                    key={condition.id}
                    control={<Checkbox
                        id={condition.id}
                       checked={conditions[condition.name] || false} 
                       onChange={handleChange}
                       name={condition.name} 
                       disabled={activeConditions && activeConditions.length === 3 && !activeConditions.includes(condition.name)} 
                    />}
                    label={condition.name}
                  />
                ))}
              
            </FormGroup>
          </FormControl>

      </div>
    </>
  );
};


export default SelectorComponent;