import React from 'react';

import { ListItem } from './ListItem';

function List(props) {
    const {items, deleteItem} = props;

    return (
        <ul>
            {
                items.map(
                    item => 
                        <ListItem 
                            item={item} 
                            deleteItem={deleteItem} 
                        />
                )
            }
        </ul>
    );
}

export { List };