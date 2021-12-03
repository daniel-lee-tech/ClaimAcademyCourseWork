import React, {useState} from 'react';

function ListItem(props) {
    const {item, deleteItem} = props;

    const [completed, setCompleted] = useState(item.completed);
    const [name] = useState(item.name);

    function toggleHandler() {
        setCompleted(item.toggleComplete());
    }

    return (
        <li key={item.id}>
            <span key={completed} style={{textDecoration: `${completed ? "line-through" : "none"}`}}>
                {name}
            </span>
            <button 
                onClick={toggleHandler}>
                    toggle
            </button> 
            <button 
                onClick={() => deleteItem(item)}>
                x
            </button>
        </li>
    )
}

export { ListItem };