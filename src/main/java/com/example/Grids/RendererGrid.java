package com.example.Grids;

import com.example.Model.Person;
import com.example.Service.PersonService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.renderers.TextRenderer;

import java.util.Random;

public class RendererGrid {

        private VerticalLayout content=new VerticalLayout();
        private HorizontalLayout navigationBar=new HorizontalLayout();
        private Grid grid=new Grid();
        public RendererGrid(){

                BeanItemContainer<Person> container=new BeanItemContainer<Person>(Person.class);
                container.addAll(PersonService.findAll());

                grid.setContainerDataSource(container);
                grid.setSelectionMode(Grid.SelectionMode.MULTI);
                grid.getColumn("firstName").setRenderer(new TextRenderer());
                grid.getColumn("id").setRenderer(new NumberRenderer("The id is %d"));
                grid.setFrozenColumnCount(2);
                initializeButtons();


                navigationBar.setSpacing(true);
                content.setMargin(true);
                content.addComponents(navigationBar,grid);
        }

        private void initializeButtons() {
                Button removeColumn=new Button("Remove column", e->{
                  grid.removeColumn("lastName");
                });
                Button frozen=new Button("Change Frozen columns", e->{
                        grid.setFrozenColumnCount(grid.getFrozenColumnCount()==2 ? 1 : 2);
                });
                navigationBar.addComponents(removeColumn,frozen);
        }

        public VerticalLayout getContent(){
                return content;
        }

}


