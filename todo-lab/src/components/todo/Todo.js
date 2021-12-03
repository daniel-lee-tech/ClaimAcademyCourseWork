import React, {useState} from 'react';
import {List} from './List';

class Item {
    constructor(name, completed) {
        this.id = Math.random();
        this.name = name;
        this.completed = completed;
    }

    toggleComplete() {
        this.completed = !this.completed;
        return this.completed;
    }
}

function Todo() {
    const [items, setItems] = useState([new Item("butter", false), new Item("milk", false), new Item("cheese", false)]);
    const [inputItem, setInputItem] = useState(new Item("", false));

    function inputHandler(event) {
        const value = event.target.value;

        inputItem.name = value;
        
        setInputItem(inputItem);
    }


    function addTodo() {
        setItems([...items, inputItem]);
        setInputItem(new Item("", false));
    }

    function deleteItem(deletedItem) {
        setItems(items.filter((item) => deletedItem.id !== item.id));
    }


    return <div>
        <h1>Todo List</h1>
        <List items={items} setItems={setItems} deleteItem={deleteItem} />
        <input 
            value={inputItem.value} 
            onChange={inputHandler} 
            type="text" 
            placeholder="add a todo" />
        <button 
            onClick={addTodo}>
            Add
        </button>
    </div>
}

export { Todo };