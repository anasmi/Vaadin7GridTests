package com.example.Grids;

import com.example.Model.Person;
import com.example.Service.PersonService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class SimpleGrid{
        private VerticalLayout layout=new VerticalLayout();
        public SimpleGrid(){
                BeanItemContainer<Person> container=new BeanItemContainer<Person>(Person.class);
                container.addAll(PersonService.findAll());

                Grid grid=new Grid();
                grid.setContainerDataSource(container);
                grid.getColumn("firstName").setHeaderCaption("Updated First Name header");
                grid.setColumnOrder("firstName","lastName");
                layout.addComponent(grid);
        }

        public VerticalLayout getContent(){
                return layout;
        }
}
